package com.hcl.rubikbank.service;

import java.util.List;

import com.hcl.rubikbank.dto.FavouriteResponseDto;

public interface FavouriteService {

	List<FavouriteResponseDto> getFavoriteAccounts(Integer pageCount);

}
