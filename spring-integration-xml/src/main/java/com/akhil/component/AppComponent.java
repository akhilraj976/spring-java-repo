package com.akhil.component;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class AppComponent {

	public String print(Message<?> message) {

		return "from inbound gateway, in Pring";

	}

	public void printConsole(Message<?> message) {

		System.out.println(message);

	}

}
