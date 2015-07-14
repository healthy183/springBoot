package org.springBoot.batch3.annotation.run;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springBoot.batch3.annotation.jobConfig.ModularJobConfiguration;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(classes=ModularJobConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ModularJobTests {

	@Autowired
	private JobRegistry jobRegistry;
 
	@Autowired
	private JobLauncher jobLauncher;
 
	@Autowired
	private DataSource dataSource;
 
	private JdbcTemplate jdbcTemplate;
 
	@Before
	public void setup(){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
 
	@Test
	public void testLaunchJob() throws Exception {
		Job job = jobRegistry.getJob("flatfileToDbJob");
		jobLauncher.run(job, new JobParameters());
		assertThat(jdbcTemplate.queryForObject("select count(*) from partner",Integer.class),is(6));
		job = jobRegistry.getJob("flatfileToDbWithParametersJob");
		assertThat(job.getName(),is("flatfileToDbWithParametersJob"));
	}
	
}
