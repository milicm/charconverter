package com.mm.charconverter.exception;

public class ConvTypeException extends RuntimeException {

	private static final long serialVersionUID = -8097721245933016206L;

	public ConvTypeException() {
		super();
	}

	public ConvTypeException(String message) {
		super(message);
	}

	public ConvTypeException(String message, Throwable cause) {
		super(message, cause);
	}

}
