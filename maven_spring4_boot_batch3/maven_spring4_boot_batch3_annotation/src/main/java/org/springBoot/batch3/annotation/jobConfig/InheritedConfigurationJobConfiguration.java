package org.springBoot.batch3.annotation.jobConfig;

import org.springBoot.batch3.annotation.listener.step.LogSkipListener;
import org.springBoot.batch3.annotation.model.Person;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.repeat.CompletionPolicy;
import org.springframework.batch.repeat.policy.SimpleCompletionPolicy;
import org.springframework.context.annotation.Bean;

public class InheritedConfigurationJobConfiguration  extends CommonJobConfigurationForInheritance {
	
	@Bean
	public Job inheritedConfigurationJob(){
		return customJobBuilders().get("inheritedConfigurationJob")
				.start(step())
				.build();
	}
 
	@Bean
	public Step step(){
		return customStepBuilders().get("step")
				/*.faultTolerant()
				.skipLimit(10)
				.skip(UnknownGenderException.class)*/
				.listener(logSkipListener())
				.build();
	}
 
	@Override
	@Bean
	public ItemProcessor<Person, Person> processor() {
		return new PersonItemProcessor();
	}
 
	@Override
	@Bean
	public CompletionPolicy completionPolicy() {
		return new SimpleCompletionPolicy(3);
	}
 
	@Bean
	public LogSkipListener logSkipListener(){
		return new LogSkipListener();
	}
	
	

}
