package com.spring.core;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Event {

	@Min(0)
	private Integer id;
	@NotEmpty
	private String title;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
