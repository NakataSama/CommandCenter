package com.marsprobe.commandcenter.exceptions;

@SuppressWarnings("serial")
public class InvalidIdException extends Exception {
	public InvalidIdException(String errorMessage) {
		super(errorMessage);
	}
}
