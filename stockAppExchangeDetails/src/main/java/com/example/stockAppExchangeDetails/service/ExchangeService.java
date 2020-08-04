package com.example.stockAppExchangeDetails.service;
import java.util.List;

import com.example.stockAppExchangeDetails.dto.ExchangeDto;
import com.example.stockAppExchangeDetails.model.ExchangeEntity;
public interface ExchangeService {

    public ExchangeEntity createExchange(ExchangeDto exchangeDto);
    public ExchangeEntity findByExchangeId(Integer exchangeId);
    public ExchangeEntity findByExchangeName(String exchangeName);
//    public CompanyEntity findByUserIdAndEmail(String userId, String email);
//    public CompanyEntity findByUserIdOrEmail(String userId, String email);
}
