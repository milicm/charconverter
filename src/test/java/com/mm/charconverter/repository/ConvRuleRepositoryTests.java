package com.mm.charconverter.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mm.charconverter.CharConverterApplicationTests;
import com.mm.charconverter.domain.ConvRule;
import com.mm.charconverter.util.ConvType;

public class ConvRuleRepositoryTests extends CharConverterApplicationTests {

	@Autowired
	private ConvRuleRepository convRuleRepository;

	@Test
	public void save() {
		List<ConvRule> convRules = convRuleRepository.findAll();
		assertNotNull(convRules);
		assertFalse(convRules.isEmpty());
	}
	
	@Test
	public void findCyrToLat() {
		ConvRule convRule = convRuleRepository.findByRuleCode(ConvType.CYR_TO_LAT.toString());
		assertNotNull(convRule);
	}

	@Test
	public void findLatToCyr() {
		ConvRule convRule = convRuleRepository.findByRuleCode(ConvType.LAT_TO_CYR.toString());
		assertNotNull(convRule);
	}
	
}
