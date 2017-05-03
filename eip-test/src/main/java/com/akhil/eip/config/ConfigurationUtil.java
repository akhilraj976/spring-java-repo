package com.akhil.eip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.http.inbound.HttpRequestHandlingMessagingGateway;
import org.springframework.integration.json.ObjectToJsonTransformer;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.StringMessageConverter;

@Configuration
public class ConfigurationUtil {
	
	@Bean(name="/api/in/**")
	public HttpRequestHandlingMessagingGateway inputRequest(){
		HttpRequestHandlingMessagingGateway gateway = new HttpRequestHandlingMessagingGateway();
		gateway.setRequestChannelName("httpRequestChannel");
		gateway.setReplyChannelName("httpResponseChannel");
		gateway.setErrorChannelName("httpErrorChannel");
		gateway.setRequestPayloadType(String.class);
		return gateway;
	}
	
	@Bean
	public MappingJackson2MessageConverter jsonMessageConverter() {
		return new MappingJackson2MessageConverter();
	}
	
	@Bean
	public ObjectToJsonTransformer objectToJsonTransformer() {
		return new ObjectToJsonTransformer();
	}
	@Bean
	public StringMessageConverter stringMessageConverter() {
		return new StringMessageConverter();
	}
	
	@Bean
	public MessageChannel httpRequestChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel httpResponseChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel httpErrorChannel() {
		return new DirectChannel();
	}
	/*@Bean
	public MessageChannel myChannel2() {
		DirectChannel channel = new DirectChannel();
		channel.setDatatypes(String.class);
		return channel;
	}*/
}
