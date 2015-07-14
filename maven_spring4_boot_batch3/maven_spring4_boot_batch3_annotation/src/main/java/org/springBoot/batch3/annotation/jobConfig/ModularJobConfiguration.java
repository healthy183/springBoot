package org.springBoot.batch3.annotation.jobConfig;

import javax.sql.DataSource;

import org.springBoot.batch3.annotation.dbConfig.InfrastructureConfiguration;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.ApplicationContextFactory;
import org.springframework.batch.core.configuration.support.GenericApplicationContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableBatchProcessing(modular=true)
public class ModularJobConfiguration {

	@Autowired
	private InfrastructureConfiguration infrastructureConfiguration;
	
	@Bean
	public DataSource dataSource(){
		return infrastructureConfiguration.dataSource();
	}
 
	@Bean
	public ApplicationContextFactory someJobs() {
		return new GenericApplicationContextFactory(FlatfileToDbJobConfiguration.class);
	}
 
	@Bean
	public ApplicationContextFactory someMoreJobs() {
		return new GenericApplicationContextFactory(FlatfileToDbWithParametersJobConfiguration.class);
	}
	
	
}
