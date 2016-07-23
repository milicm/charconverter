package com.mm.charconverter.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mm.charconverter.CharConverterApplicationTests;
import com.mm.charconverter.domain.dto.ConverterObject;
import com.mm.charconverter.service.ConverterService;
import com.mm.charconverter.util.ConvType;
import com.mm.charconverter.util.RestConst;

@IntegrationTest({ "server.port=0" })
public class ConverterRestControllerTests extends CharConverterApplicationTests {

	@Value("${local.server.port}")
	private int port;

	@Autowired
	private ConverterService converterService;

	private RestTemplate restTemplate = new TestRestTemplate();

	private String getBaseUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void cyrToLatTest() {
		ConverterObject c = new ConverterObject(0, ConvType.CYR_TO_LAT.toString(), "Јохн Дое", "");
		ResponseEntity<ConverterObject> entity = restTemplate.postForEntity(getBaseUrl() + RestConst.REST_CONVERTER_URL,
				c, ConverterObject.class);
		ConverterObject result = entity.getBody();
		assertEquals(HttpStatus.OK.value(), result.getStatus());
		assertEquals(converterService.convert(c.getText(), ConvType.CYR_TO_LAT), result.getConvertedText());
	}

	@Test
	public void latToCyrTest() {
		ConverterObject c = new ConverterObject(0, ConvType.LAT_TO_CYR.toString(), "John Doe", "");
		ResponseEntity<ConverterObject> entity = restTemplate.postForEntity(getBaseUrl() + RestConst.REST_CONVERTER_URL,
				c, ConverterObject.class);
		ConverterObject result = entity.getBody();
		assertEquals(HttpStatus.OK.value(), result.getStatus());
		assertEquals(converterService.convert(c.getText(), ConvType.LAT_TO_CYR), result.getConvertedText());
	}

	@Test
	public void unknownTypeTest() {
		ConverterObject c = new ConverterObject(0, "UNKNOWN_TYPE", "John Doe", "");
		ResponseEntity<ConverterObject> entity = restTemplate.postForEntity(getBaseUrl() + RestConst.REST_CONVERTER_URL,
				c, ConverterObject.class);
		ConverterObject result = entity.getBody();
		assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatus());
	}

	@Test
	public void nullTypeTest() {
		ConverterObject c = new ConverterObject(0, null, "John Doe", "");
		ResponseEntity<ConverterObject> entity = restTemplate.postForEntity(getBaseUrl() + RestConst.REST_CONVERTER_URL,
				c, ConverterObject.class);
		ConverterObject result = entity.getBody();
		assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatus());
	}

	@Test
	public void nullTextTest() {
		ConverterObject c = new ConverterObject(0, ConvType.CYR_TO_LAT.toString(), null, "");
		ResponseEntity<ConverterObject> entity = restTemplate.postForEntity(getBaseUrl() + RestConst.REST_CONVERTER_URL,
				c, ConverterObject.class);
		ConverterObject result = entity.getBody();
		assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatus());
	}

}
