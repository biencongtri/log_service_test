package com.javainuse.controller;

import com.javainuse.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.service.RabbitMQSender;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/javainuse-rabbitmq/")
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam String content) {
		SystemLog systemLog = new SystemLog();
		systemLog.setController("/javainuse-rabbitmq/producer");
		systemLog.setContent(content);
		systemLog.setLogType(LogType.Debug);
		rabbitMQSender.send(systemLog);

		return "Message sent to the RabbitMQ JavaInUse Successfully";
	}


	@GetMapping(value = "/log-user")
	public String logUser() {
		UserLog userLog = UserLog.builder()
				.modified(LocalDateTime.now())
				.actionCurd(ActionCurd.DELETE)
				.ipAddress("0.0.0.0")
				.modifiedBy("1l")
				.modifiedByInstanceId("1")
				.tableName("user")
				.objectDataNew("test")
				.objectId("test")
				.id("index")
				.objectDataOld("test")
				.build();
		rabbitMQSender.send(userLog);
		return "Message sent to the RabbitMQ JavaInUse Successfully";
	}

}

