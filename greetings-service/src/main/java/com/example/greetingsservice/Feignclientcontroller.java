package com.example.greetingsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Feignclientcontroller {


	@GetMapping(value="/getGreetings/{localeId}", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getGreetingsAndUserInfoViaFeign(@PathVariable(name= "localeId") String langCode) {
		System.out.println("Using the feign client controller of StockMarket Application to fetch the greetings information for locale= " + langCode);

		String greetMsg = "Hello! This has been routed through feign client for StockMarket Application! Please leave your message here : "+langCode;

		return new ResponseEntity<String>(greetMsg, HttpStatus.OK);
	}

}