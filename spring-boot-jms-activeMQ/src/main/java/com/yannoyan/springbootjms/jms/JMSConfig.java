package com.yannoyan.springbootjms.jms;

import java.util.concurrent.Executors;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.scheduling.config.TaskExecutorFactoryBean;

//这里是spring boot的配置注释，记得加上
@Configuration
@EnableJms
public class JMSConfig {
	
	@Bean
	public JmsListenerContainerFactory<?> topicListenerFactory(ConnectionFactory connectionFactory){
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setPubSubDomain(true); //默认为false，监听queue，设置为true可以监听topic
		factory.setConnectionFactory(connectionFactory);
		//开启并发消费
		factory.setTaskExecutor(Executors.newFixedThreadPool(6));
		factory.setConcurrency("6");
		return factory;
	}
	
	@Bean
	public JmsListenerContainerFactory<?> queueListenerFactory(ConnectionFactory connectionFactory){
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setPubSubDomain(false);
		factory.setConnectionFactory(connectionFactory);
		factory.setTaskExecutor(Executors.newFixedThreadPool(6));
		factory.setConcurrency("6");
		return factory;
	}
}
