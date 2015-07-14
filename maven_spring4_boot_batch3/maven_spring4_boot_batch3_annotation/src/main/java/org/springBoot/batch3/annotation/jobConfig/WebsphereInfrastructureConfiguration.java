package org.springBoot.batch3.annotation.jobConfig;

import javax.sql.DataSource;

import org.springBoot.batch3.annotation.dbConfig.InfrastructureConfiguration;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.WebSphereUowTransactionManager;


@Configuration
@EnableBatchProcessing
//@PropertySource("classpath:batch.properties")
public class WebsphereInfrastructureConfiguration implements BatchConfigurer, InfrastructureConfiguration {

	@Autowired
	private InfrastructureConfiguration infrastructureConfiguration;
	
	
	
	@Override
	public DataSource dataSource() {
		return infrastructureConfiguration.dataSource();
	}

	@Override
	public JobExplorer getJobExplorer() throws Exception {
		return null;
	}

	@Override
	public JobLauncher getJobLauncher() throws Exception {
		
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(getJobRepository());
		jobLauncher.afterPropertiesSet();
		return jobLauncher;
	}

	@Override
	public JobRepository getJobRepository() throws Exception {
	
		JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
		factory.setDataSource(dataSource());
		factory.setTransactionManager(getTransactionManager());
		factory.afterPropertiesSet();
		return  (JobRepository) factory.getObject();
		
	}

	@Override
	public PlatformTransactionManager getTransactionManager() throws Exception {
		return new WebSphereUowTransactionManager();
	}

}
