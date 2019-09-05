package com.hcl.rubikbank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.rubikbank.dto.LoginResponseDto;
import com.hcl.rubikbank.service.LoginService;
/**
 * @author Venkat . This is the controller class for login the customer
 *
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class LoginController {
	@Autowired
	LoginService loginService;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@PostMapping("/login/{customerId}")
	public ResponseEntity<LoginResponseDto> login(@PathVariable("customerId") Integer customerId) {
		logger.info("inside the login Controller method");
		return new ResponseEntity<>(loginService.userLogin(customerId), HttpStatus.OK);

	}
}
