package com.akhil.eip.router;

import org.springframework.integration.annotation.Router;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class RequestRouter {
	
	@Router(inputChannel="httpRequestChannel")
	public String route(Message<?> message){
		
		if(message.getHeaders().get("http_requestUrl").toString().contains("/getResult")){
			return "myChannel1";
		}else if(message.getHeaders().get("http_requestUrl").toString().contains("/putResult")){
			return "myChannel2";
		}else{
			return "myChannel3";
		}
		
	}
}
