package com.example.stockAppExchangeDetails.service;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.stockAppExchangeDetails.dao.ExchangeRepository;
import com.example.stockAppExchangeDetails.dto.ExchangeDto;
import com.example.stockAppExchangeDetails.model.ExchangeEntity;

@Service
@EnableTransactionManagement
public class ExchangeServiceImpl implements ExchangeService {
    private ExchangeRepository exchangeRepository;
    @Autowired
    public ExchangeServiceImpl(ExchangeRepository exchangeRepository) {
  		this.exchangeRepository = exchangeRepository;
  	}
    @Override
    @Transactional
    public ExchangeEntity createExchange(ExchangeDto exchangeDto) {
//        companyDto.setCompanyId();
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ExchangeEntity exchangeEntity=mapper.map(exchangeDto,ExchangeEntity.class);
        exchangeRepository.save(exchangeEntity);
        return mapper.map(exchangeEntity,ExchangeEntity.class);
    }
    
  

	@Override
    @Transactional
    public ExchangeEntity findByExchangeId(Integer exchangeId) {
        return exchangeRepository.findByExchangeId(exchangeId);
    }

    @Override
    @Transactional
    public ExchangeEntity findByExchangeName(String exchangeName) {
        return exchangeRepository.findByExchangeName(exchangeName);
    }

	
    
  
//	@Override
//	@Transactional
//	public CompanyEntity findByUserIdAndEmail(String userId, String email) {
//		return  companyRepository.findByUserIdAndEmail(userId, email);
//	}
//	@Override
//	public CompanyEntity findByUserIdOrEmail(String userId, String email) {
//		return companyRepository.findByUserIdOrEmail(userId, email);
//	}
	
	}

