package org.springBoot.batch3.annotation.listener.job;

import lombok.extern.slf4j.Slf4j;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.StepExecution;

@Slf4j
public class ProtocolListener implements JobExecutionListener  {@Override
	
	public void beforeJob(JobExecution paramJobExecution) {
		
	}

	@Override
	public void afterJob(JobExecution paramJobExecution) {
		log.info("this is ProtocolListener!");
	}}

