package com.example.stockAppPriceDetails.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stockAppPriceDetails.model.PriceEntity;

@Repository
public interface PriceRepository extends CrudRepository<PriceEntity,Integer> {
	
    public PriceEntity findByCompanyId(Integer companyId);
    public PriceEntity findByStockExchange(String stockExchange);
//    public List<PriceEntity> findAllByUserNameStartingWith(String pattern);
    
//    public CompanyEntity findByUserIdAndEmail(String userId, String email);
//    public CompanyEntity findByUserIdOrEmail(String userId, String email);

}

