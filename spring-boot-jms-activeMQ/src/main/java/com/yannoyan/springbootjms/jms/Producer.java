package com.yannoyan.springbootjms.jms;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service("producer")
public class Producer {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void SendMessage(Destination destination,String message) {
		jmsTemplate.convertAndSend(destination,message);
	}
	
	
}
