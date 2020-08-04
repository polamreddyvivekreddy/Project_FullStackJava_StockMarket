package com.example.stockAppPriceDetails.ui;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockAppPriceDetails.dto.PriceDto;
import com.example.stockAppPriceDetails.model.PriceEntity;
import com.example.stockAppPriceDetails.service.PriceService;




@RestController 
@RequestMapping("/price")
public class PriceRestController {
	private PriceService priceService;

	@Autowired

	public PriceRestController(PriceService priceService) {
		this.priceService = priceService;
	}

	
	@PostMapping("/addStock")
	public ResponseEntity<PriceEntity> createStock(@RequestBody PriceEntity priceDetails) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		PriceDto priceDto = mapper.map(priceDetails, PriceDto.class);
		priceService.createStock(priceDto);
		PriceEntity priceEntity = mapper.map(priceDto, PriceEntity.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(priceEntity);
	}





	@GetMapping("/id/{companyId}")
	public ResponseEntity<PriceEntity> findCompanyById(@PathVariable("companyId") Integer companyId)
			{
		PriceEntity priceEntity = priceService.findByCompanyId(companyId);
		
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return ResponseEntity.status(HttpStatus.FOUND).body(mapper.map(priceEntity, PriceEntity.class));

	}
	
	@GetMapping("/exchangeName/{exchangeName}")
	public ResponseEntity<PriceEntity> findCompanyByExchangeName(@PathVariable("exchangeName") String exchangeName)
			 {
		PriceEntity priceEntity = priceService.findByStockExchange(exchangeName);

		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return ResponseEntity.status(HttpStatus.FOUND).body(mapper.map(priceEntity, PriceEntity.class));

	}
	

	
	
	
	
	
//	@GetMapping("/users/{userId}/{email}")
//	public ResponseEntity<CompanyResponseModelEntity> findUserByUserIdAndEmail(@PathVariable("userId") String userId, @PathVariable("email") String email)
//			throws CompanyNotFoundException {
//		//CompanyEntity userEntity = userService.findByUserIdAndEmail(userId, email);
//		
//		CompanyEntity userEntity = userService.findByUserIdOrEmail(userId, email);
//		if (userEntity == null) {
//			throw new CompanyNotFoundException("user not found with the user id and email: " + userId);
//		}
//		ModelMapper mapper = new ModelMapper();
//		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//		return ResponseEntity.status(HttpStatus.FOUND).body(mapper.map(userEntity, CompanyResponseModelEntity.class));
//
//	}
}
