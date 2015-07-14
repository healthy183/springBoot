package org.springBoot.batch3.annotation.partition;

import java.io.IOException;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.partition.support.MultiResourcePartitioner;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

public class PartitionJob {

	@Bean
	public Job flatfileToDbPartitioningJob(){
		return jobBuilders.get("flatfileToDbPartitioningJob")
				.listener(protocolListener())
				.start(partitionStep())
				.build();
	}
 
	@Bean
	public Step partitionStep(){
		return stepBuilders.get("partitionStep")
				.partitioner(flatfileToDbStep())
				.partitioner("flatfileToDbStep", partitioner())
				.taskExecutor(infrastructureConfiguration.taskExecutor())
				.build();
	}
 
	@Bean
	public Step flatfileToDbStep(){
		return stepBuilders.get("flatfileToDbStep")
				.<Partner,Partner>chunk(1)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.listener(logProcessListener())
				.build();
	}
 
	@Bean
	public Partitioner partitioner(){
		MultiResourcePartitioner partitioner = new MultiResourcePartitioner();
		Resource[] resources;
		try {
			resources = resourcePatternResolver.getResources("file:src/test/resources/*.csv");
		} catch (IOException e) {
			throw new RuntimeException("I/O problems when resolving the input file pattern.",e);
		}
		partitioner.setResources(resources);
		return partitioner;
	}
	
	
}
