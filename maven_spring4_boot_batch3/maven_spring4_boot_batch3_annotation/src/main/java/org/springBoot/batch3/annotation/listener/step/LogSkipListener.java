package org.springBoot.batch3.annotation.listener.step;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class LogSkipListener implements StepExecutionListener  {

	@Override
	public void beforeStep(StepExecution paramStepExecution) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExitStatus afterStep(StepExecution paramStepExecution) {
		return ExitStatus.COMPLETED;
	}

}
