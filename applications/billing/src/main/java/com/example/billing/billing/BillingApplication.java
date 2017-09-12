package com.example.billing.billing;

import com.example.billing.BillingClient;
import com.example.billing.RabbitBillingClient;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.example")
@EnableDiscoveryClient
@EnableCircuitBreaker
public class BillingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingApplication.class, args);
	}


	@Bean
	@LoadBalanced
	public RestTemplate createRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public BillingConsumer createBillingClient() { return new BillingConsumer(); }

	@Bean
	public Queue queue(){
		return new Queue("ums-billing-queue", false);
	}

}
