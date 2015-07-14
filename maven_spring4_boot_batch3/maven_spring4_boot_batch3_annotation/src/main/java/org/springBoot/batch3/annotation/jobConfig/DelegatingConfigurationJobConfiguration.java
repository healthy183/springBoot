package org.springBoot.batch3.annotation.jobConfig;

import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(CommonJobConfigurationForDelegation.class)
public class DelegatingConfigurationJobConfiguration {

	@Autowired
	private CommonJobConfigurationForDelegation commonJobConfiguration;
	
	@Bean
	public Job delegatingConfigurationJob(){
		return commonJobConfiguration.customJobBuilders()
				.get("delegatingConfigurationJob")
				.start(step())
				.build();
	}
	
	....
	
}
