package com.mm.charconverter.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

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

	@Test
	public void latToCyrMockDataTest() throws FileNotFoundException, URISyntaxException {
		String result = null;
		String dataLat = null;
		String dataCyr = null;
		Scanner scannerLat = new Scanner(new File(this.getClass().getResource("/mockdata/mock_data_lat.csv").toURI()));
		Scanner scannerCyr = new Scanner(new File(this.getClass().getResource("/mockdata/mock_data_cyr.csv").toURI()));
		// Skip header row
		scannerLat.nextLine();
		scannerCyr.nextLine();
		while (scannerLat.hasNextLine()) {
			dataLat = scannerLat.nextLine();
			dataCyr = scannerCyr.nextLine();
			result = converterService.convert(dataLat, ConvType.LAT_TO_CYR);
			assertNotNull(result);
			assertEquals(dataCyr, result);
		}
		scannerLat.close();
		scannerCyr.close();
	}

	@Test
	public void cyrToLatMockDataTest() throws FileNotFoundException, URISyntaxException {
		String result = null;
		String dataCyr = null;
		String dataLat = null;
		Scanner scannerCyr = new Scanner(new File(this.getClass().getResource("/mockdata/mock_data_cyr.csv").toURI()));
		Scanner scannerLat = new Scanner(new File(this.getClass().getResource("/mockdata/mock_data_lat.csv").toURI()));
		// Skip header row
		scannerCyr.nextLine();
		scannerLat.nextLine();
		while (scannerCyr.hasNextLine()) {
			dataCyr = scannerCyr.nextLine();
			dataLat = scannerLat.nextLine();
			result = converterService.convert(dataCyr, ConvType.CYR_TO_LAT);
			assertNotNull(result);
			assertEquals(dataLat, result);
		}
		scannerLat.close();
		scannerCyr.close();
	}
}
