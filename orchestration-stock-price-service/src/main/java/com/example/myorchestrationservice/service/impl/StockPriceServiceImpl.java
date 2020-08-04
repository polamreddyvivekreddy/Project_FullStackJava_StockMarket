package com.example.myorchestrationservice.service.impl;

import com.example.myorchestrationservice.dto.CompanyDto;
import com.example.myorchestrationservice.dto.PriceDto;
import com.example.myorchestrationservice.dto.StockPriceDto;
import com.example.myorchestrationservice.service.StockPriceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockPriceServiceImpl implements StockPriceService {

	@Autowired
    private RestTemplate restTemplate;

    public StockPriceServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //using SPEL(Spring Expression Language
    @Value("${stock.url}")
    private String stockServiceURL;
    //using SPEL(Spring Expression Language
    @Value("${price.url}")
    private String priceServiceURL;

    private static final Logger LOGGER = LoggerFactory.getLogger(StockPriceServiceImpl.class);

    @Override
    public StockPriceDto getStockPrice(Integer companyId) throws Exception {
        StockPriceDto stockPriceDto = new StockPriceDto();

        LOGGER.info("Fetching Customer and Order details for OrderId: {}", companyId);

        CompanyDto companyDto = getCompanyDto(companyId);

        if (companyDto != null) {
        	stockPriceDto.setCompanyDto(companyDto);
        	stockPriceDto.setPriceDto(getPriceDto(companyDto.getCompanyId()));
        } else {
            LOGGER.error("No company found for, Id: {}", companyId);
        }

        return stockPriceDto;
    }

    private CompanyDto getCompanyDto(Integer companyId) {
        ResponseEntity<CompanyDto> companyDtoResponse = restTemplate.getForEntity(stockServiceURL + companyId, CompanyDto.class);
        return companyDtoResponse.getBody();
    }

    private PriceDto getPriceDto(Integer companyId) {
        ResponseEntity<PriceDto> priceDtoResponse = restTemplate.getForEntity(priceServiceURL + companyId, PriceDto.class);
        return priceDtoResponse.getBody();
    }
}
