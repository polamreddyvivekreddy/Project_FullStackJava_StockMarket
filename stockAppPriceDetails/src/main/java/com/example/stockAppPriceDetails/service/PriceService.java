package com.example.stockAppPriceDetails.service;
import java.util.List;

import com.example.stockAppPriceDetails.dto.PriceDto;
import com.example.stockAppPriceDetails.model.PriceEntity;
public interface PriceService {

    public PriceEntity createStock(PriceDto priceDto);
    public PriceEntity findByCompanyId(Integer companyId);
    public PriceEntity findByStockExchange(String stockExchange);
//    public List<UserEntity> findAllByUserNameStartingWith(String pattern);
//    public CompanyEntity findByUserIdAndEmail(String userId, String email);
//    public CompanyEntity findByUserIdOrEmail(String userId, String email);
}
