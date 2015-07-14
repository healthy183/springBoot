package org.springBoot.batch3.annotation.partition;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class StandaloneInfrastructureConfiguration  implements InfrastructureConfiguration{

	@Autowired
	private InfrastructureConfiguration infrastructureConfiguration;
	
	
	@Override
	public DataSource dataSource() {
		return infrastructureConfiguration.dataSource();
	}

	@Override
	public TaskExecutor taskExecutor() {
		
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setMaxPoolSize(4);
		taskExecutor.afterPropertiesSet();
		return taskExecutor;
		
	}

	
	
	
}
