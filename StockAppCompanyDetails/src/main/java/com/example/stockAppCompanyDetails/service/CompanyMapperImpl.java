package com.example.stockAppCompanyDetails.service;

import com.example.stockAppCompanyDetails.dto.CompanyDto;
import com.example.stockAppCompanyDetails.dto.CompanyMapper;
import com.example.stockAppCompanyDetails.model.CompanyEntity;

public class CompanyMapperImpl implements CompanyMapper{

	@Override
	public CompanyDto companyEntityToDto(CompanyEntity companyEntity) {
		// TODO Auto-generated method stub
		
		CompanyDto compDto = new CompanyDto();
		
		compDto.setCompanyId(companyEntity.getCompanyId());
		compDto.setCompanyCEO(companyEntity.getCompanyCEO());
		compDto.setCompanyBoardOfDirectors(companyEntity.getCompanyBoardOfDirectors());
		compDto.setCompanyBriefWriteUp(companyEntity.getCompanyBriefWriteUp());
		compDto.setCompanyName(companyEntity.getCompanyName());
		compDto.setCompanySector(companyEntity.getCompanySector());
		compDto.setCompanyTurnover(companyEntity.getCompanyTurnover());
		
		return compDto;
	}


}
