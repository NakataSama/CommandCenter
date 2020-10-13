package com.marsprobe.commandcenter.exceptions;

@SuppressWarnings("serial")
public class DuplicateIdException extends Exception {
	public DuplicateIdException(String errorMesage) {
		super(errorMesage);
	}
}
