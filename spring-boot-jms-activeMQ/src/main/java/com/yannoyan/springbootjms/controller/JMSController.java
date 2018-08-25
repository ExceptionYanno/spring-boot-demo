package com.yannoyan.springbootjms.controller;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yannoyan.springbootjms.jms.Producer;

@RestController
public class JMSController {
	
	@Autowired
	public Producer producer;
	
	@RequestMapping("/queue/{id}")
	public void sendToQueue(@PathVariable("id") Integer id) {
		Destination destination = new ActiveMQQueue("mytest.queue");
		producer.SendMessage(destination, "queue消息-"+id);
	}
	
	@RequestMapping("/topic/{id}")
	public void sendToTopic(@PathVariable("id") Integer id) {
		Destination destination = new ActiveMQTopic("mytest.topic");
		producer.SendMessage(destination, "topic消息-"+id);
	}
	
}
