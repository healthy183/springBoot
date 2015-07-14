package org.springBoot.batch3.annotation.partition;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;

public interface  InfrastructureConfiguration {

	@Bean
	public abstract DataSource dataSource();
 
	@Bean
	public abstract TaskExecutor taskExecutor();
	
}
