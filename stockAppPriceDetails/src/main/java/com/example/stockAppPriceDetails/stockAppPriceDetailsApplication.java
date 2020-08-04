package com.example.stockAppPriceDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class stockAppPriceDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(stockAppPriceDetailsApplication.class, args);
	}

}
