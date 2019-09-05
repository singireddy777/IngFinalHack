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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.rubikbank.dto.LoginResponseDto;
import com.hcl.rubikbank.service.LoginService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class LoginControllerTest {
	@InjectMocks
	LoginController loginController;
	@Mock
	LoginService loginService;
	MockMvc mockMvc;
	private static final Logger logger = LoggerFactory.getLogger(LoginControllerTest.class);

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
	}

	@Test
	public void loginTest() throws Exception {

		LoginResponseDto login = new LoginResponseDto();
		login.setCustomerId(1);
		login.setMessage("Login Success..");
		logger.info("inside the loginTest method..");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/login/{customerId}", 1).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
