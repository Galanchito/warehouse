package com.warehouse.exception;

import org.slf4j.helpers.MessageFormatter;

public abstract class MessageException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	protected MessageException(String line, Object[] args) {
		super(MessageFormatter.arrayFormat(line, args).getMessage());
	}
}
