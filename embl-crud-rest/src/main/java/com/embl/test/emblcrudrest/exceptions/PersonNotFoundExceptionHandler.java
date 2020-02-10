package com.embl.test.emblcrudrest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PersonNotFoundExceptionHandler extends Exception{

	public PersonNotFoundExceptionHandler(String error) {
		super(error);
	}

}
