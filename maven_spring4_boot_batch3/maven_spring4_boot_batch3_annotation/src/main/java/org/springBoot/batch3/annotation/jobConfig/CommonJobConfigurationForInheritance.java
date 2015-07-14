package org.springBoot.batch3.annotation.jobConfig;

import org.springBoot.batch3.annotation.dbConfig.InfrastructureConfiguration;
import org.springBoot.batch3.annotation.listener.job.ProtocolListener;
import org.springBoot.batch3.annotation.listener.step.LogProcessListener;
import org.springBoot.batch3.annotation.model.Person;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.repeat.CompletionPolicy;
import org.springframework.batch.repeat.policy.SimpleCompletionPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

public abstract  class CommonJobConfigurationForInheritance {



	@Autowired
	private JobRepository jobRepository;
	
	
	@Autowired
	private PlatformTransactionManager transactionManager;

	
	@Autowired
	private InfrastructureConfiguration infrastructureConfiguration;
	
	
	
	@Bean
	public CustomJobBuilderFactory customJobBuilders(){
		return new CustomJobBuilderFactory(jobRepository, protocolListener());
	}
	
	protected CustomStepBuilderFactory<Person,Person> customStepBuilders(){
		return new CustomStepBuilderFactory<Person,Person>(
				jobRepository,
				transactionManager,
				completionPolicy(),
				reader(),
				processor(),
				writer(),
				logProcessListener());
	}
	
	
	@Bean
	public CompletionPolicy completionPolicy(){
		return new SimpleCompletionPolicy(1);
	}
	
	public abstract ItemProcessor<Person,Person> processor();
	
	
	@Bean
	public FlatFileItemReader<Person> reader(){
		FlatFileItemReader<Person> itemReader = new FlatFileItemReader<Person>();
		itemReader.setLineMapper(lineMapper());
		itemReader.setResource(new ClassPathResource("Person-import.csv"));
		return itemReader;
	}
	
	
	@Bean
	public LineMapper<Person> lineMapper(){
		DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<Person>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[]{"fisrtName","lastName"});
		//lineTokenizer.setIncludedFields(new int[]{0,2});
		BeanWrapperFieldSetMapper<Person> fieldSetMapper = new BeanWrapperFieldSetMapper<Person>();
		fieldSetMapper.setTargetType(Person.class);
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		return lineMapper;
	}
	
	@Bean
	public ItemWriter<Person> writer(){
		JdbcBatchItemWriter<Person> itemWriter = new JdbcBatchItemWriter<Person>();
		itemWriter.setSql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)");
		itemWriter.setDataSource(infrastructureConfiguration.dataSource());
		itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
		return itemWriter;
	}
	
	
	@Bean
	public ProtocolListener protocolListener(){
		return new ProtocolListener();
	}
	
	
	@Bean
	public LogProcessListener logProcessListener(){
		return new LogProcessListener();
	}
	
	
	

	
}
