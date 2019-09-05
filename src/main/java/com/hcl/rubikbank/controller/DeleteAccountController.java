package com.hcl.rubikbank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.rubikbank.dto.DeleteAccountResponseDto;
import com.hcl.rubikbank.service.DeleteAccountService;
/**
 * @author Venkat. This is the controller class for delete the favourite account
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class DeleteAccountController {
	private static final Logger logger = LoggerFactory.getLogger(DeleteAccountController.class);
	@Autowired
	DeleteAccountService deleteAccountService;
	@DeleteMapping("/favourite/{favouriteId}/{customerId}")
	public ResponseEntity<DeleteAccountResponseDto> deleteAccount(@PathVariable("favouriteId") Integer favouriteId,
			@PathVariable("customerId") Integer customerId) {
		logger.info("inside the deleteAccount method in controller..");
		return new ResponseEntity<>(deleteAccountService.deleteAccounts(favouriteId, customerId), HttpStatus.OK);

	}
}
