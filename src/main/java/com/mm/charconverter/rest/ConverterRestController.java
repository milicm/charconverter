package com.mm.charconverter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mm.charconverter.domain.dto.ConverterObject;
import com.mm.charconverter.exception.ConvTypeException;
import com.mm.charconverter.service.ConverterService;
import com.mm.charconverter.util.ConvType;
import com.mm.charconverter.util.RestConst;

@RestController
@RequestMapping(RestConst.REST_CONVERTER_URL)
public class ConverterRestController {

	@Autowired
	private ConverterService converterService;

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ConverterObject convert(@RequestBody(required = true) ConverterObject convObjReq) {
		try {
			if (convObjReq.getType() == null || convObjReq.getText() == null) {
				throw new ConvTypeException("Unknown text or conversion type!");
			}
			ConvType convType = ConvType.findByType(convObjReq.getType());
			String convertedText = converterService.convert(convObjReq.getText(), convType);
			return new ConverterObject(HttpStatus.OK.value(), convObjReq.getType(), convObjReq.getText(),
					convertedText);
		} catch (ConvTypeException ex) {
			return new ConverterObject(HttpStatus.BAD_REQUEST.value(), convObjReq.getType(), convObjReq.getText(),
					ex.getMessage());
		}
	}
}
