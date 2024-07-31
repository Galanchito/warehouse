package com.warehouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceConflictException extends MessageException {

	private static final long serialVersionUID = 1L;

	public ResourceConflictException(String line, Object... args) {
		super(line, args);
	}
}