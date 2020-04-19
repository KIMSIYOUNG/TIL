package com.spring.security;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HomeController.class)
class HomeControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	@WithMockUser
	void create() throws Exception {
		mockMvc.perform(get("/hello")
			.accept(MediaType.TEXT_HTML))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("hello"));
	}

	@Test
	@WithMockUser
	void create2() throws Exception {
		mockMvc.perform(get("/my"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("my"));
	}

	@Test
	void create3() throws Exception {
		mockMvc.perform(get("/my"))
			.andDo(print())
			.andExpect(status().isUnauthorized());
	}
}