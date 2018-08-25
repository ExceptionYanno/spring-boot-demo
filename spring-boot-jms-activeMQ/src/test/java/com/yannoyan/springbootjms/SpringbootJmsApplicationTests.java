package com.yannoyan.springbootjms;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yannoyan.springbootjms.jms.Producer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJmsApplicationTests {
	
	@Autowired
	private Producer producer;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void test001() {
		Destination destination = new ActiveMQQueue("mytest.queue");
		while(true) {
			for(int i=0;i<20;i++) {
				producer.SendMessage(destination, "你好，这是消息" + i);
			}
		}
	}
	
	@Test
	public void test002() {
		Destination destination = new ActiveMQTopic("mytest.topic");
		//while(true) {
			for(int i=0;i<20;i++) {
				producer.SendMessage(destination, "你好，这是消息" + i);
			}
		//}
	}

}
