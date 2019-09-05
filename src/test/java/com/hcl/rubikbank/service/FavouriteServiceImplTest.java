package com.hcl.rubikbank.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.hcl.rubikbank.dto.FavouriteResponseDto;
import com.hcl.rubikbank.entity.BankData;
import com.hcl.rubikbank.entity.Favourite;
import com.hcl.rubikbank.repository.BankDataRepository;
import com.hcl.rubikbank.repository.FavouriteRepository;

/**
 * 
 * @author DeepikaSivarajan
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class FavouriteServiceImplTest {
	@Mock
	FavouriteRepository favouriteRepository;
	@Mock
	BankDataRepository bankDataRepository;
	@InjectMocks
	FavouriteServiceImpl favouriteServiceImpl;

	List<FavouriteResponseDto> responseList;
	FavouriteResponseDto favouriteResponseDto;
	Page<Favourite> favourite;
	Favourite favData; 
	List<Favourite> favouriteList;
	BankData bankData;
	Pageable pageable;

	@Before
	public void setUp() {
		favData = new Favourite();
		responseList = new ArrayList<>();
		favouriteResponseDto = new FavouriteResponseDto();
		favouriteList = new ArrayList<Favourite>();
		favData.setAccountName("Bridge Foundation");
		favData.setCustomerId(1);
		favData.setFavouriteId(1);
		favData.setBankId(1);
		favouriteList.add(favData);
		
		favourite = new PageImpl<Favourite>(favouriteList);
		
		bankData = new BankData();
		pageable = (Pageable) PageRequest.of(0, 5);
		bankData.setBankCode("1235");
		bankData.setBankId(1);
		bankData.setBankName("Tokio Bank");

		favouriteResponseDto.setBankName("Tokio Bank");
		favouriteResponseDto.setCustomerId(1);
		responseList.add(favouriteResponseDto);

	}

	@Test
	public void testGetFavoriteAccounts() {
		Mockito.when(favouriteRepository.findAll(pageable)).thenReturn(favourite);
		Mockito.when(bankDataRepository.findByBankId(Mockito.anyInt())).thenReturn(bankData);
		List<FavouriteResponseDto> response = favouriteServiceImpl.getFavoriteAccounts(Mockito.anyInt());
		assertEquals(bankData.getBankName(), response.get(0).getBankName());
	}

}
