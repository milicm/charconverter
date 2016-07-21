package com.mm.charconverter.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mm.charconverter.CharConverterApplicationTests;
import com.mm.charconverter.util.ConvType;

public class ConverterServiceTests extends CharConverterApplicationTests {

	@Autowired
	private ConverterService converterService;

	@Test
	public void cyrToLatTest() {
		String result = converterService.convert("Јохн Дое", ConvType.CYR_TO_LAT);
		assertNotNull(result);
		assertEquals("John Doe", result);
	}

	@Test
	public void latToCyrTest() {
		String result = converterService.convert("John Doe", ConvType.LAT_TO_CYR);
		assertNotNull(result);
		assertEquals("Јохн Дое", result);
	}
	
}
