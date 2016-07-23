package com.mm.charconverter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.charconverter.domain.ConvRule;
import com.mm.charconverter.exception.ConverterException;
import com.mm.charconverter.repository.ConvRuleRepository;
import com.mm.charconverter.service.ConverterService;
import com.mm.charconverter.util.ConvType;

@Service
public class ConverterServiceImpl implements ConverterService {

	@Autowired
	private ConvRuleRepository convRuleRepository;

	@Override
	public String convert(String text, ConvType convType) throws ConverterException {
		ConvRule rule = convRuleRepository.findByRuleCode(convType.toString());
		int i = 0;
		String[] from = rule.getRuleFrom().split(" ");
		String[] to = rule.getRuleTo().split(" ");
		for (String value : from) {
			text = text.replaceAll(value, to[i]);
			i++;
		}
		return text;
	}

}
