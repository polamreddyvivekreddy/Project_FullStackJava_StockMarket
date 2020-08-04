package com.example.stockAppExchangeDetails.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stockAppExchangeDetails.model.ExchangeEntity;

@Repository
public interface ExchangeRepository extends CrudRepository<ExchangeEntity,Integer> {
	
    public ExchangeEntity findByExchangeId(Integer exchangeId);
    public ExchangeEntity findByExchangeName(String exchangeName);
    
//    public CompanyEntity findByUserIdAndEmail(String userId, String email);
//    public CompanyEntity findByUserIdOrEmail(String userId, String email);

}

