package com.mm.charconverter.exception;

public class ConverterException extends RuntimeException {

	private static final long serialVersionUID = -8097721245933016206L;

	public ConverterException() {
		super();
	}

	public ConverterException(String message) {
		super(message);
	}

	public ConverterException(String message, Throwable cause) {
		super(message, cause);
	}

}
