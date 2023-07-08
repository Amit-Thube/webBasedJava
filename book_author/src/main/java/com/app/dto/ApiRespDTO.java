package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiRespDTO {
	
	private String message;

	public ApiRespDTO(String message) {
		super();
		this.message = message;
	}

}
