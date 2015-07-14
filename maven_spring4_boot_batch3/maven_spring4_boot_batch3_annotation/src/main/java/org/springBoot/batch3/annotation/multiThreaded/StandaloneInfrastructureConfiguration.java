package org.springBoot.batch3.annotation.multiThreaded;

public class StandaloneInfrastructureConfiguration  implements InfrastructureConfiguration {

	
	@Bean
	public DataSource dataSource(){
		return null;
	}
 
	@Bean
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setMaxPoolSize(4);
		taskExecutor.afterPropertiesSet();
		return taskExecutor;
	}
 
	@Bean
	public ConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory("tcp://localhost:61616");
	}
 
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("queueName");
	}
 
	@Bean
	public BrokerService broker() throws Exception{
		BrokerService broker = new BrokerService();
		// configure the broker
		broker.addConnector("tcp://localhost:61616");
		broker.start();
		return broker;
	}
 
	@Bean
	public JmsTemplate jmsTemplate(){
		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
		jmsTemplate.setDefaultDestination(queue());
		jmsTemplate.setReceiveTimeout(500);
		return jmsTemplate;
	}
	
	
}


