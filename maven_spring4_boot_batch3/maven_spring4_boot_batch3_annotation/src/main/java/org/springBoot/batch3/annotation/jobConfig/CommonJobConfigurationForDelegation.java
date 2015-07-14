package org.springBoot.batch3.annotation.jobConfig;

import org.springBoot.batch3.annotation.dbConfig.InfrastructureConfiguration;
import org.springBoot.batch3.annotation.listener.job.ProtocolListener;
import org.springBoot.batch3.annotation.listener.step.LogProcessListener;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class CommonJobConfigurationForDelegation {

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

	
	@Bean
	public ProtocolListener protocolListener(){
		return new ProtocolListener();
	}
	
	
	
	
	
}
