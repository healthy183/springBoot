package org.springBoot.batch3.annotation.listener.step;

import lombok.extern.slf4j.Slf4j;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

@Slf4j
public class LogProcessListener implements StepExecutionListener  {

	
	public void beforeStep(StepExecution paramStepExecution){
		
		
	}

	public  ExitStatus afterStep(StepExecution paramStepExecution){
		
		log.info("this is LogProcessListener.class!");
		
		return ExitStatus.COMPLETED;
	}
	
	
	
}

