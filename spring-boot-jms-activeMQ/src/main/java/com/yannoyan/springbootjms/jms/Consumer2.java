package com.yannoyan.springbootjms.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Consumer2 {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	/*
	 * 第二个消费者功能要注意：
	 * sendto之后需要加上return 
	 */
	@JmsListener(destination = "mytest.queue",containerFactory="queueListenerFactory")
	@SendTo("out.queue")
	public String receiveMessage(String message) {
		System.out.println(Thread.currentThread().getName()+":C2收到queue消息：" + message);
		return "已转发:"+message;
	}
	
	@JmsListener(destination="mytest.topic",containerFactory="topicListenerFactory")
	public void receiveTopic(String message) {
		System.out.println(Thread.currentThread().getName()+":C2收到topic消息：" + message);
	}
	
}
