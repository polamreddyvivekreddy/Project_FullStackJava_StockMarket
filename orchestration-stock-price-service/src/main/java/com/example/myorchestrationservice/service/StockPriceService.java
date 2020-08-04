package com.example.myorchestrationservice.service;

import com.example.myorchestrationservice.dto.StockPriceDto;

public interface StockPriceService {


    StockPriceDto getStockPrice(Integer companyId) throws Exception;
}
