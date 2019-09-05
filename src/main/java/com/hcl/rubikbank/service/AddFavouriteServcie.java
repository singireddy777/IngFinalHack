package com.hcl.rubikbank.service;

import com.hcl.rubikbank.dto.AddFavouriteRequestDto;
import com.hcl.rubikbank.dto.AddFavouriteResponseDto;

public interface AddFavouriteServcie {
	
	AddFavouriteResponseDto addFaourite(AddFavouriteRequestDto addFavouriteRequestDto);

}
