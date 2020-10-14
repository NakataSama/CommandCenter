package com.marsprobe.commandcenter.exceptions;

@SuppressWarnings("serial")
public class ExistingProbeInPositionException extends Exception {
	public ExistingProbeInPositionException(String errorMessage) {
		super(errorMessage);
	}
}
