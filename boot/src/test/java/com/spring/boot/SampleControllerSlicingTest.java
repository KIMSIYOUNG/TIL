package com.spring.boot;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerSlicingTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	SampleService sampleService;

	@Test
	public void helloTest() throws Exception {
		when(sampleService.getName()).thenReturn("kyle");

		mockMvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(content().string("hellokyle"));
	}
}