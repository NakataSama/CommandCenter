package com.marsprobe.commandcenter.exceptions;

@SuppressWarnings("serial")
public class InvalidFieldSizeException extends Exception {
	public InvalidFieldSizeException(String errorMessage) {
		super(errorMessage);
	}
}
