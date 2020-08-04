package com.example.feignservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("stock-app-company-details")
public interface CustomerServiceClient {
	@GetMapping(value="/company/{companyId}")
	public String getGreetings(@PathVariable(name= "companyId") String langCode);
}