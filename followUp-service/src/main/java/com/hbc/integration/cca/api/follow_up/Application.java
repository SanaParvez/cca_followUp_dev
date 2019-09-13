package com.hbc.integration.cca.api.follow_up;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableDiscoveryClient
public class Application {

	
	//private final MD5 MD5;

	
	
	
	
	public static void main(String[] args) {		
		
		
	
        SpringApplication.run(Application.class, args);
	}
	
	  
	    @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
	
	
	
}
