package org.springBoot.batch3.annotation.job;

import org.springBoot.batch3.annotation.dbConfig.InfrastructureConfiguration;
import org.springBoot.batch3.annotation.listener.job.ProtocolListener;
import org.springBoot.batch3.annotation.listener.step.LogProcessListener;
import org.springBoot.batch3.annotation.model.Person;
import org.springBoot.batch3.annotation.processor.PersonItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


@Configuration
public class CsvJob {

	
	@Autowired
	private JobBuilderFactory jobBF;
	
	@Autowired
	private StepBuilderFactory stepBF;
	
	@Autowired
	private InfrastructureConfiguration infrastructureConfiguration;
	
	
	private static final String OVERRIDDEN_BY_EXPRESSION = null;
	
	@Bean
	public Job csvJobStart(){
		return jobBF.get("csvJobStart")
				    .listener(protocolListener())
					.start(step())
					.build();
	}
	
	
	@Bean
	public Step step(){
		return stepBF.get("step")
				.<Person,Person>chunk(1)
				.reader(scvReader(OVERRIDDEN_BY_EXPRESSION))
				.processor(processor())
				.writer(writer())
				.listener(logProcessListener())
				/*.faultTolerant()
				.skipLimit(10)
				.skip(Exception.class)*/
				.build();
	}
	
	
	
	@Bean
	@StepScope
	public ItemReader<Person> scvReader(@Value("#{jobParameters[pathToFile]}") String filePath){
		
		FlatFileItemReader<Person> itemReader = new FlatFileItemReader<Person>();
		
		itemReader.setResource(new ClassPathResource(filePath));
		
		itemReader.setLineMapper(lineMapper());
		
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
	public ItemProcessor<Person,Person> processor(){
		return new PersonItemProcessor();
	}
	
	
	@Bean
	public ItemWriter<Person> writer(){
		
		JdbcBatchItemWriter<Person> itemWriter = new JdbcBatchItemWriter<Person>();
	
		itemWriter.setItemSqlParameterSourceProvider
			(new BeanPropertyItemSqlParameterSourceProvider<Person>());
		
		itemWriter.setDataSource(infrastructureConfiguration.dataSource());
		
		itemWriter.setSql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)");
		
		return  itemWriter;
	}
	
	
	@Bean
	public LogProcessListener logProcessListener(){
		return new LogProcessListener();
	}
	
	
	@Bean
	public ProtocolListener protocolListener(){
		return new ProtocolListener();
	}
	
	
	
	
	
	
}
