package com.example.myorchestrationservice.dto;
import lombok.Data;

@Data
public class StockPriceDto {

    private CompanyDto companyDto;

    private PriceDto priceDto;
}
