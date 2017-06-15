/**
 * 
 */
package com.centrica.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * Spring boot greeting application
 * 
 * @author wemccl
 *
 */
@SpringBootApplication
@ComponentScan(value = { "com.centrica.task" })
public class Queue1Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    SpringApplication.run(Queue1Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
