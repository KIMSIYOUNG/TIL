package com.spring.boot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@PostMapping("/user/create")
	public User create(@RequestBody User user) {
		return user;
	}
}
