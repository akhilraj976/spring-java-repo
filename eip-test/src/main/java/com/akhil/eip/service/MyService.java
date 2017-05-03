package com.akhil.eip.service;

import java.util.List;
import java.util.Map;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class MyService {
	
	@ServiceActivator(inputChannel="myChannel1", outputChannel="responseChannel")
	public String testService1(Map<String, List<String>> queryParams){
		String input = queryParams.get("input").get(0);
		return "Recieved input:" + input;
	}
	
	@ServiceActivator(inputChannel="myChannel2", outputChannel="responseChannel")
	public String testService2(String input){
		return "testService2";
	}
	
	@ServiceActivator(inputChannel="myChannel3", outputChannel="responseChannel")
	public Object testService3(Message<?> message){
		return message.getPayload();
	}
}
