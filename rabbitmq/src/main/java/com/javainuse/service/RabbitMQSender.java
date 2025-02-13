package com.javainuse.service;

import com.javainuse.model.SystemLog;
import com.javainuse.model.UserLog;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.javainuse.model.Employee;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${javainuse.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${javainuse.rabbitmq.routingkey}")
	private String routingkey;	
	String kafkaTopic = "java_in_use_topic";
	
	public void send(Employee company) {
		amqpTemplate.convertAndSend(exchange, routingkey, company);
		System.out.println("Send msg = " + company);
	    
	}

	public void send(SystemLog systemLog) {
		amqpTemplate.convertAndSend(exchange, routingkey, systemLog);
		System.out.println("Send msg = " + systemLog);
	}

	public void send(UserLog userLog) {
		amqpTemplate.convertAndSend(exchange, routingkey, userLog);
		System.out.println("Send msg = " + userLog);
	}
}