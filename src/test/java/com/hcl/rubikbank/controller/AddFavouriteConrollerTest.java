package com.hcl.rubikbank.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.rubikbank.dto.AddFavouriteRequestDto;
import com.hcl.rubikbank.service.AddFavouriteServcie;

@RunWith(MockitoJUnitRunner.class)
public class AddFavouriteConrollerTest {
	@Mock
	AddFavouriteServcie favouriteService;
	@InjectMocks
	AddFavouriteController favouriteController;
	@Autowired
	MockMvc mockMvc;

	AddFavouriteRequestDto addFavouriteRequestDto;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(favouriteController).build();
		addFavouriteRequestDto = getAddFavouriteRequestDto();
	}

	@Test
	public void testAddFavouriteControllerTest() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/favourite").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(asJsonString(addFavouriteRequestDto)))
				.andExpect(status().isCreated());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public AddFavouriteRequestDto getAddFavouriteRequestDto() {
		return new AddFavouriteRequestDto("Vodafone", "12341234123412341234", "icici", 1, 1);
	}

}
