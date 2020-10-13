package com.marsprobe.commandcenter.exceptions;

@SuppressWarnings("serial")
public class InvalidRequestBodyException extends Exception {
	public InvalidRequestBodyException(String errorMessage) {
		super(errorMessage);
	}
}
