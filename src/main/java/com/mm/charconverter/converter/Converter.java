package com.mm.charconverter.converter;

public class Converter {

	private static Converter instance;

	private Converter() {

	}

	public static Converter getInstance() {
		if (instance == null) {
			instance = new Converter();
		}
		return instance;
	}

}
