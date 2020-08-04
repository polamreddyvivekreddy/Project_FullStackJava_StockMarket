package com.example.stockAppCompanyDetails.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


import com.example.stockAppCompanyDetails.dao.CompanyRepository;
import com.example.stockAppCompanyDetails.dto.CompanyDto;
import com.example.stockAppCompanyDetails.dto.CompanyMapper;
import com.example.stockAppCompanyDetails.exception.CompanyNotFoundException;
import com.example.stockAppCompanyDetails.model.CompanyEntity;
import com.example.stockAppCompanyDetails.shared.CompanyResponseModelEntity;

@Service
@EnableTransactionManagement
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;
    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    @Override
    @Transactional
    public CompanyResponseModelEntity createCompany(CompanyDto companyDto) {
//        companyDto.setCompanyId();
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CompanyEntity companyEntity=mapper.map(companyDto,CompanyEntity.class);
        companyRepository.save(companyEntity);
        return mapper.map(companyEntity,CompanyResponseModelEntity.class);
    }
    
    @Override
    @Transactional
    public CompanyEntity findByCompanyId(Integer companyId) {
    	
      
    return companyRepository.findByCompanyId(companyId);
    
    }

    @Override
    @Transactional
    public CompanyEntity findByCompanyName(String companyName) {
        return companyRepository.findByCompanyName(companyName);
    }
	@Override
	@Transactional
	public List<CompanyEntity> findByCompanyNameStartingWith(String pattern) {

		return companyRepository.findByCompanyNameStartingWith(pattern);
	}
	@Override
	public List<CompanyEntity> findByCompanyNameContaining(String pattern) {
		// TODO Auto-generated method stub
		return companyRepository.findByCompanyNameContaining(pattern);
	}
	@Override
	public List<CompanyEntity> findAll() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}
	 @Override
	    public CompanyDto getCompanyDto(Integer companyId) throws Exception {
//	        LOGGER.info("Fetching Order details for CustomerId: {}", companyId);
	        Optional<CompanyEntity> companyEntity = companyRepository.findById(companyId);
	        CompanyDto companyDto = null;

//            companyDto = CompanyMapper.INSTANCE.companyEntityToDto(companyEntity)

	     //System.out.println(companyEntity.toString());
	            //companyDto = CompanyMapper.INSTANCE.companyEntityToDto(companyEntity.get());
	     companyDto = new CompanyMapperImpl().companyEntityToDto(companyEntity.get());
	        

	        return companyDto;
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

