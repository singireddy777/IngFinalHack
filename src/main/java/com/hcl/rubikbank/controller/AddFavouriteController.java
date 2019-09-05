package com.hcl.rubikbank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.rubikbank.dto.AddFavouriteRequestDto;
import com.hcl.rubikbank.dto.AddFavouriteResponseDto;
import com.hcl.rubikbank.service.AddFavouriteServcie;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class AddFavouriteController {
	@Autowired
	AddFavouriteServcie addFavouriteService;
	private static final Logger logger = LoggerFactory.getLogger(AddFavouriteController.class);

	@PostMapping("/favourite")
	public ResponseEntity<AddFavouriteResponseDto> addFavourite(
			@RequestBody AddFavouriteRequestDto addFavouriteRequestDto) {
		logger.info("inside the AddFavouriteController Controller method");
		return new ResponseEntity<>(addFavouriteService.addFaourite(addFavouriteRequestDto), HttpStatus.CREATED);

	}
}
