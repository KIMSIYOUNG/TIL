package com.spring.boot;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleControllerTestWithWebFlux {

	@Autowired
	WebTestClient webTestClient;

	@MockBean
	SampleService sampleService;

	@Test
	public void helloTest() {
		when(sampleService.getName()).thenReturn("kyle");

		webTestClient.get().uri("/hello").exchange()
			.expectStatus().isOk()
			.expectBody(String.class).isEqualTo("hellokyle");
	}
}