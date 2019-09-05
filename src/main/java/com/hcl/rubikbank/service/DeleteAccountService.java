package com.hcl.rubikbank.service;

import org.springframework.stereotype.Service;

import com.hcl.rubikbank.dto.DeleteAccountResponseDto;

@Service
public interface DeleteAccountService {

	public DeleteAccountResponseDto deleteAccounts(Integer favouriteId, Integer customerId);
}
