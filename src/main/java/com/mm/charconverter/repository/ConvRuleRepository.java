package com.mm.charconverter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.mm.charconverter.domain.ConvRule;

@Repository
public interface ConvRuleRepository extends JpaRepository<ConvRule, Long> {

	ConvRule findByRuleCode(String ruleCode);

}
