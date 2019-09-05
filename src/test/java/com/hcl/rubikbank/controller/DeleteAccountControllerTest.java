package com.hcl.rubikbank.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.hcl.rubikbank.dto.DeleteAccountResponseDto;
import com.hcl.rubikbank.service.DeleteAccountService;
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class DeleteAccountControllerTest {
private static final Logger logger = LoggerFactory.getLogger(DeleteAccountControllerTest.class);
	@Mock DeleteAccountService deleteAccountService; 
	@InjectMocks DeleteAccountController deleteAccountController;
	MockMvc mockMvc;
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(deleteAccountController).build();
	}
	@Test
	public void deleteAccountTest() throws Exception {
		logger.info("inside the deleteAccountTest method..");
		DeleteAccountResponseDto delete = new DeleteAccountResponseDto();
		delete.setMessage("Account deleted successfully from favorite accounts list");
		logger.info("inside the test delete method..");
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/favourite/{favouriteId}/{customerId}", 1,1).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
