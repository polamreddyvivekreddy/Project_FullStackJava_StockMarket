package com.example.feignservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value= "/feign")
public class Feignclientcontroller {
private GreetingsClient greetingsClient;
private CustomerServiceClient customerServiceClient;

	public Feignclientcontroller(CustomerServiceClient customerServiceClient) {
		this.customerServiceClient = customerServiceClient;
	}
	
//	@GetMapping("/{customerId}")
//	@HystrixCommand(fallbackMethod= "defaultResponse")
//	public ResponseEntity<String> getCustomerInfoViaFeign(@PathVariable(name= "customerId") String langCode) {
////		String greetMsg = greetingsClient.getGreetings(langCode);
//		String greetMsg = customerServiceClient.getGreetings(langCode);
//		return new ResponseEntity<>(greetMsg, HttpStatus.OK);
//	}
	

	@GetMapping("/{localeId}")
	@HystrixCommand(fallbackMethod= "defaultResponse")
	public ResponseEntity<String> getGreetingsAndUserInfoViaFeign(@PathVariable(name= "localeId") String langCode) {
		String greetMsg = greetingsClient.getGreetings(langCode);
		return new ResponseEntity<>(greetMsg, HttpStatus.OK);
	}

	// When we define a fallback-method, the fallback-method must match the same parameters of the method where you define the Hystrix Command using the hystrix-command annotation.
	public ResponseEntity<String> defaultResponse(String err) {
		System.out.println("You are seeing this fallback response because the underlying microservice is down.");
		err = "We regret for the inconvinience! We will fix StockMarket App ASAP ";
		return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}