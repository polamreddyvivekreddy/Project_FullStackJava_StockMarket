package com.example.stockAppPriceDetails.service;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.stockAppPriceDetails.dao.PriceRepository;
import com.example.stockAppPriceDetails.dto.PriceDto;
import com.example.stockAppPriceDetails.model.PriceEntity;

@Service
@EnableTransactionManagement
public class PriceServiceImpl implements PriceService {
    private PriceRepository priceRepository;
    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository) {
		this.priceRepository = priceRepository;
	}

	
    @Override
    @Transactional
    public PriceEntity createStock(PriceDto priceDto) {
//        companyDto.setCompanyId();
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        PriceEntity priceEntity=mapper.map(priceDto,PriceEntity.class);
        priceRepository.save(priceEntity);
        return mapper.map(priceEntity,PriceEntity.class);
    }
    


	@Override
    @Transactional
    public PriceEntity findByCompanyId(Integer companyId) {
        return priceRepository.findByCompanyId(companyId);
    }

    @Override
    @Transactional
    public PriceEntity findByStockExchange(String stockExchange) {
        return priceRepository.findByStockExchange(stockExchange);
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

