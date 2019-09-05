package com.hcl.rubikbank.service;

import org.springframework.stereotype.Service;

import com.hcl.rubikbank.dto.LoginResponseDto;

@Service
public interface LoginService {

	public LoginResponseDto userLogin(Integer customerId);
	
}
