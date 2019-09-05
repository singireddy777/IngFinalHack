package com.hcl.rubikbank.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcl.rubikbank.dto.UpdateAccountRequestDto;
import com.hcl.rubikbank.dto.UpdateAccountResponseDto;
import com.hcl.rubikbank.entity.Favourite;
import com.hcl.rubikbank.exception.CommonException;
import com.hcl.rubikbank.repository.FavouriteRepository;

@RunWith(MockitoJUnitRunner.class)
public class UpdateAccountServiceImplTest {

	private static final Logger logger = LoggerFactory.getLogger(UpdateAccountServiceImplTest.class);
	@InjectMocks
	UpdateAccountServiceImpl updateAccountServiceImpl;

	@Mock
	FavouriteRepository favouriteRepository;

	UpdateAccountResponseDto updateAccountResponseDto;
	UpdateAccountRequestDto updateAccountRequestDto;
	Favourite favourite;

	public Favourite getFavourite() {
		Favourite favourite = new Favourite();
		favourite.setAccountNumber("ES121234123412341234");
		favourite.setAccountName("Bridge Foundation");
		favourite.setAccountStatus("1");
		favourite.setBankId(1);
		favourite.setCreationDate(LocalDate.now());
		favourite.setCustomerId(1);
		favourite.setFavouriteId(1);
		return favourite;
	}

	public UpdateAccountRequestDto getUpdateAccountRequestDto() {
		UpdateAccountRequestDto updateAccountRequestDto = new UpdateAccountRequestDto();
		updateAccountRequestDto.setAccountName("Vodafone");
		updateAccountRequestDto.setAccountNumber("ES121234123412341222");
		return updateAccountRequestDto;
	}

	public UpdateAccountResponseDto getUpdateAccountResponseDto() {
		UpdateAccountResponseDto updateAccountResponseDto = new UpdateAccountResponseDto();
		updateAccountResponseDto.setMessage("edit successful");
		return updateAccountResponseDto;
	}

	@Before
	public void setup() {
		favourite = getFavourite();
		updateAccountRequestDto = getUpdateAccountRequestDto();
		updateAccountResponseDto = getUpdateAccountResponseDto();
	}

	@Test
	public void testUpdateAccount() {
		logger.info("in test update account");
		Mockito.when(favouriteRepository.findByFavouriteId(Mockito.anyInt())).thenReturn(Optional.of(favourite));
		UpdateAccountResponseDto response = updateAccountServiceImpl.updateAccount(1, updateAccountRequestDto);
		assertEquals("Account details successfully updated in favorite accounts list.", response.getMessage());
	}

	@Test(expected = CommonException.class)
	public void testUpdateAccount_1() {
		updateAccountServiceImpl.updateAccount(1, updateAccountRequestDto);
	}

}
