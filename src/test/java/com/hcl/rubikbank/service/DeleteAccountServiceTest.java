package com.hcl.rubikbank.service;

import static org.junit.Assert.assertEquals;

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

import com.hcl.rubikbank.dto.DeleteAccountResponseDto;
import com.hcl.rubikbank.entity.Favourite;
import com.hcl.rubikbank.exception.CommonException;
import com.hcl.rubikbank.repository.FavouriteRepository;

@RunWith(MockitoJUnitRunner.class)
public class DeleteAccountServiceTest {
	@Mock
	FavouriteRepository favouriteRepository;
	@InjectMocks
	DeleteAccountServiceImpl deleteAccountService;
	private static final Logger logger = LoggerFactory.getLogger(DeleteAccountServiceTest.class);
	DeleteAccountResponseDto deleteAccountResponseDto;
	Favourite favourite;
	public Favourite getFavourite() {
		Favourite favourite = new Favourite();
		favourite.setAccountStatus("0");
		return favourite;
	}
	public DeleteAccountResponseDto getDeleteAccountResponseDto() {
		DeleteAccountResponseDto deleteAccountResponseDto = new DeleteAccountResponseDto();
		deleteAccountResponseDto.setMessage("Account deleted successfully from favorite accounts list");
		return deleteAccountResponseDto;
	}
	@Before
	public void setup() {
		favourite = getFavourite();
		deleteAccountResponseDto = getDeleteAccountResponseDto();
	}
	@Test
	public void deleteAccountsTest() {
		logger.info("inside the deleteAccountsTest in service");
		Mockito.when(favouriteRepository.findByFavouriteIdAndCustomerId(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(Optional.of(favourite));
		DeleteAccountResponseDto response = deleteAccountService.deleteAccounts(1, 1);
		assertEquals("Account deleted successfully from favorite accounts list", response.getMessage());
	}
	@Test(expected = CommonException.class)
	public void deleteAccountsTest_1() {
		 deleteAccountService.deleteAccounts(1, 1);
	}
}
