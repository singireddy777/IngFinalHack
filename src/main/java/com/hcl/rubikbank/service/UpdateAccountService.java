package com.hcl.rubikbank.service;

import com.hcl.rubikbank.dto.UpdateAccountRequestDto;
import com.hcl.rubikbank.dto.UpdateAccountResponseDto;

public interface UpdateAccountService {
	
	public UpdateAccountResponseDto updateAccount(Integer favouriteId, UpdateAccountRequestDto updateAccountRequestDto);
	
}
