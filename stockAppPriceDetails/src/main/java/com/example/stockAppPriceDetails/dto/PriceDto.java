package com.example.stockAppPriceDetails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto {
    private Integer companyId;
    private Integer stockCurrentPrice;
    private String address;
    private String date;
    private String stockExchange;
    private String time;
    
    
}
