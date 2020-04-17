package com.spring.boot;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void create() throws Exception {
		String user = "{\"userName\":\"kyle\", \"password\":\"123\"}";
		mockMvc.perform(post("/user/create")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.content(user))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.userName", is(equalTo("kyle"))))
			.andExpect(jsonPath("$.password", is(equalTo("123"))));
	}
}