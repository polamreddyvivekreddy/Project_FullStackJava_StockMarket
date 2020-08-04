package com.example.stockAppCompanyDetails.dto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.example.stockAppCompanyDetails.model.CompanyEntity;


@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);
    CompanyDto companyEntityToDto(CompanyEntity companyEntity);
}
