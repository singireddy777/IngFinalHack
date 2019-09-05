package com.hcl.rubikbank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.rubikbank.dto.UpdateAccountRequestDto;
import com.hcl.rubikbank.dto.UpdateAccountResponseDto;
import com.hcl.rubikbank.service.UpdateAccountService;

/**
 * @author Gurpreet Singh. This is the controller class for updating the
 *         favourite account details
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class UpdateAccountController {

	@Autowired
	UpdateAccountService updateAccountService;

	private static final Logger logger = LoggerFactory.getLogger(UpdateAccountController.class);

	/**
	 * @param Integer favouriteId, UpdateUpdateAccountRequestDto which includes
	 *                accountName, accountNumber.
	 * 
	 * @return UpdateAccountResponseDto is the output response which includes
	 *         message with status code.
	 */
	@PutMapping("/favourite/{favouriteId}")
	public ResponseEntity<UpdateAccountResponseDto> updateAccount(@PathVariable Integer favouriteId,
			@RequestBody UpdateAccountRequestDto updateAccountRequestDto) {
		logger.info("in update account ");
		UpdateAccountResponseDto response = updateAccountService.updateAccount(favouriteId, updateAccountRequestDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
