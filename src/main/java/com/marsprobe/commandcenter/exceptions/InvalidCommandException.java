package com.marsprobe.commandcenter.exceptions;

@SuppressWarnings("serial")
public class InvalidCommandException extends Exception {
	public InvalidCommandException(String errorMessage) {
		super(errorMessage);
	}
}
