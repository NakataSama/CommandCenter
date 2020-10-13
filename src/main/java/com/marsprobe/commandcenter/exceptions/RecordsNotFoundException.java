package com.marsprobe.commandcenter.exceptions;

@SuppressWarnings("serial")
public class RecordsNotFoundException extends Exception {
	public RecordsNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
