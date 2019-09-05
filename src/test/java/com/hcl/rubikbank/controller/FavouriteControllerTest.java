package com.hcl.rubikbank.controller;

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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.rubikbank.service.FavouriteService;

@RunWith(MockitoJUnitRunner.class)
public class FavouriteControllerTest {
	@Mock
	FavouriteService favouriteService;
	@InjectMocks
	FavouriteController favouriteController;
	@Autowired
	MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(favouriteController).build();
	}

	@Test
	public void testGetFavoriteAccounts() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/favourites/{pageCount}", 0)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
