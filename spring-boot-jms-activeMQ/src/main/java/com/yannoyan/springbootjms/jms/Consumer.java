package com.yannoyan.springbootjms.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Consumer {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@JmsListener(destination = "mytest.queue",containerFactory="queueListenerFactory")
	public void receiveQueue(String message) {
		System.out.println(Thread.currentThread().getName() +":C1收到queue消息：" + message);
	}
	
	@JmsListener(destination="mytest.topic",containerFactory="topicListenerFactory")
	public void receiveTopic(String message) {
		System.out.println(Thread.currentThread().getName()+":C1收到topic消息：" + message);
	}
	
}
