package com.hcl.rubikbank.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hcl.rubikbank.dto.BankDto;
import com.hcl.rubikbank.util.RubibankConstants;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class BankCodeController {
	@Autowired
	RestTemplate restTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(BankCodeController.class);

	@PostMapping("/bankDetails/{bankCode}")
	public ResponseEntity<BankDto> getBankDetails(
			@PathVariable String bankCode) {
		logger.info("inside the bankDetails Controller method");
		String bankCodeStr = bankCode.substring(4, 8);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);

		return new ResponseEntity<>(restTemplate
				.exchange(RubibankConstants.BANK_DETAILS_URL + bankCodeStr, HttpMethod.GET, entity, BankDto.class)
				.getBody(), HttpStatus.OK);

	}
}
