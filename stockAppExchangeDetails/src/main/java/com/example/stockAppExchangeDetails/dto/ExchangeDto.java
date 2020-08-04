package com.example.stockAppExchangeDetails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeDto {
    private Integer exchangeId;
    private String exchangeName;
    private String remarks;
   
}
