package com.warehouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends MessageException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message, Object... objects) {
		super(message, objects);
	}

}
