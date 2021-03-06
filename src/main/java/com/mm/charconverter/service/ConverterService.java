package com.mm.charconverter.service;

import com.mm.charconverter.exception.ConverterException;
import com.mm.charconverter.util.ConvType;

public interface ConverterService {

	String convert(String text, ConvType convType) throws ConverterException;

}
