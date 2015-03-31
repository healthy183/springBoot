package org.springBoot.batch3.annotation.dbConfig;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class InfrastructureConfigurationImpl implements
		InfrastructureConfiguration {

	@Override
	@Bean
	public DataSource dataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/springbatch3?useunicode=true&amp;characterEncoding=utf8");
	    dataSource.setUsername("root");
	    dataSource.setPassword("Qq123456");
		
		return dataSource;
		
	}

}
