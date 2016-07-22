package com.mm.charconverter.domain.dto;

public class ConverterObject {
	private int status;
	private String type;
	private String text;
	private String convertedText;

	public ConverterObject() {
		super();
	}

	public ConverterObject(int status, String type, String text, String convertedText) {
		super();
		this.status = status;
		this.type = type;
		this.text = text;
		this.convertedText = convertedText;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getConvertedText() {
		return convertedText;
	}

	public void setConvertedText(String convertedText) {
		this.convertedText = convertedText;
	}
}
