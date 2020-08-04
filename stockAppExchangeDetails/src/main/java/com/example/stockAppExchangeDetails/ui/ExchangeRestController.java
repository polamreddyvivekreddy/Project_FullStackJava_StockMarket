package com.example.stockAppExchangeDetails.ui;

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

import com.example.stockAppExchangeDetails.dto.ExchangeDto;
import com.example.stockAppExchangeDetails.model.ExchangeEntity;
import com.example.stockAppExchangeDetails.service.ExchangeService;



@RestController 
@RequestMapping("/exchange")
public class ExchangeRestController {
	private ExchangeService exchangeService;

	@Autowired

	public ExchangeRestController(ExchangeService exchangeService) {
		this.exchangeService = exchangeService;
	}

	
	
	@PostMapping("/addExchange")
	public ResponseEntity<ExchangeEntity> createExchange(@RequestBody ExchangeEntity exchangeDetails) {
		ModelMapper mapper = new ModelMapper();
		ExchangeDto exchangeDto = mapper.map(exchangeDetails, ExchangeDto.class);
		exchangeService.createExchange(exchangeDto);
		ExchangeEntity exchangeEntity = mapper.map(exchangeDto, ExchangeEntity.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(exchangeEntity);
	}





	@GetMapping("/id/{exchangeId}")
	public ResponseEntity<ExchangeEntity> findExchangeById(@PathVariable("exchangeId") Integer exchangeId)
			{
		ExchangeEntity exchangeEntity = exchangeService.findByExchangeId(exchangeId);
		ModelMapper mapper = new ModelMapper();
		return ResponseEntity.status(HttpStatus.FOUND).body(mapper.map(exchangeEntity, ExchangeEntity.class));

	}
	
	@GetMapping("/name/{exchangeName}")
	public ResponseEntity<ExchangeEntity> findExchangeByName(@PathVariable("exchangeName") String exchangeName)
			{
		ExchangeEntity exchangeEntity = exchangeService.findByExchangeName(exchangeName);
		ModelMapper mapper = new ModelMapper();
		return ResponseEntity.status(HttpStatus.FOUND).body(mapper.map(exchangeEntity, ExchangeEntity.class));

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
