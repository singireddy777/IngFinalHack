package com.hcl.rubikbank.service;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.rubikbank.dto.AddFavouriteRequestDto;
import com.hcl.rubikbank.dto.AddFavouriteResponseDto;
import com.hcl.rubikbank.entity.Favourite;
import com.hcl.rubikbank.exception.CommonException;
import com.hcl.rubikbank.repository.FavouriteRepository;
import com.hcl.rubikbank.util.RubibankConstants;
import com.hcl.rubikbank.util.SmsSender;

@RunWith(MockitoJUnitRunner.class)
public class AddFavouriteServiceImplTest {
	@Mock
	FavouriteRepository favouriteRepository;

	@InjectMocks
	AddFavouriteServiceImpl addFavouriteServiceImpl;
	
	@Mock
	SmsSender smsSender;

	AddFavouriteRequestDto addFavouriteRequestDto;
	
	Favourite favourite;

	@Before
	public void setUp() {
		addFavouriteRequestDto = getAddFavouriteRequestDto();
		favourite=getFavourite();

	}

	@Test
	public void testGetFavoriteAccounts() {
		
		Mockito.when(favouriteRepository.save(Mockito.any())).thenReturn(favourite);
		AddFavouriteResponseDto addFavouriteResponseDto=addFavouriteServiceImpl.addFaourite(addFavouriteRequestDto);
		Assert.assertEquals(RubibankConstants.ADD_SUCCESS, addFavouriteResponseDto.getMessage());

	}
	@Test(expected = CommonException.class)
	public void testGetFavoriteAccounts_1() {
		addFavouriteRequestDto.setAccountNumber("12345");
		addFavouriteServiceImpl.addFaourite(addFavouriteRequestDto);

	}

	public AddFavouriteRequestDto getAddFavouriteRequestDto() {
		return new AddFavouriteRequestDto("Vodafone", "12341234123412341234", "icici", 1, 1);
	}
	
	public Favourite getFavourite()
	{
		return new Favourite(1, "Vodafone", "12341234123412341234", "1", LocalDate.now(), 1, 1);
				
	}

}
