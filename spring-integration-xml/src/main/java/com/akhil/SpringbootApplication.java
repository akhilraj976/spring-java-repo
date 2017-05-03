package com.akhil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import com.akhil.component.SimpleGateway;

@SpringBootApplication
@ImportResource("integration-context.xml")
public class SpringbootApplication implements ApplicationRunner {

	@Autowired
	SimpleGateway gateway;
	
	public static void main(String[] args) {
		 SpringApplication.run(SpringbootApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		//this.gateway.execute("jhhh");
	}
}
