package com.example.myorchestrationservice.controller;
import com.example.myorchestrationservice.dto.StockPriceDto;
import com.example.myorchestrationservice.service.StockPriceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockPriceController {

    private StockPriceService stockPriceService;

  
    @Autowired
    public StockPriceController(StockPriceService stockPriceService) {
		this.stockPriceService = stockPriceService;
	}



	@RequestMapping(value = "/stock-price/{companyId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public StockPriceDto getStockPrice(@PathVariable Integer companyId) throws Exception {
        return stockPriceService.getStockPrice(companyId);
    }
}
