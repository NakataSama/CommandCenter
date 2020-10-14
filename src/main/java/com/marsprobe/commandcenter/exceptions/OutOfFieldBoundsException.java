package com.marsprobe.commandcenter.exceptions;

@SuppressWarnings("serial")
public class OutOfFieldBoundsException extends Exception {
	public OutOfFieldBoundsException(String errorMessage) {
		super(errorMessage);
	}
}
