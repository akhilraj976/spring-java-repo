package com.akhil.eip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.json.ObjectToJsonTransformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class JsonTransformer {
	
	@Autowired
	ObjectToJsonTransformer transformer;

	@Transformer(inputChannel="responseChannel", outputChannel="httpResponseChannel")
	public Message<?> transformMessage(Message<?> message) {
		return transformer.transform(message);
	}
}
