package com.hcl.rubikbank.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.rubikbank.dto.UpdateAccountRequestDto;
import com.hcl.rubikbank.service.UpdateAccountService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class UpdateAccountControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@InjectMocks
	UpdateAccountController updateAccountController;
	
	@Mock
	UpdateAccountService updateAccountService;
	
	UpdateAccountRequestDto updateAccountRequestDto;
	
	private static final Logger logger = LoggerFactory.getLogger(UpdateAccountControllerTest.class);

	public UpdateAccountRequestDto getUpdateAccountRequestDto()
	{ 
		UpdateAccountRequestDto updateAccountRequestDto = new UpdateAccountRequestDto();
		updateAccountRequestDto.setAccountName("Bridge Foundation");
		updateAccountRequestDto.setAccountNumber("ES501234123412341234");
		return updateAccountRequestDto;
	}
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(updateAccountController).build();
		updateAccountRequestDto = getUpdateAccountRequestDto();
	}
	
	@Test
	public void testUpdateAccount() throws Exception {
		logger.info("in test update account");
				mockMvc.perform(MockMvcRequestBuilders.put("/api/favourite/{favouriteId}", 1).contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON).content(asJsonString(updateAccountRequestDto)))
						.andExpect(status().isOk());
	}

	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
