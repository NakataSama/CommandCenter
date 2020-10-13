package com.marsprobe.commandcenter.exceptions;

@SuppressWarnings("serial")
public class UnavailableFieldException extends Exception {
	public UnavailableFieldException(String errorMessage) {
		super(errorMessage);
	}
}
