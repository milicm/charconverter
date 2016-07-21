package com.mm.charconverter.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conv_rule")
public class ConvRule implements Serializable {
	private static final long serialVersionUID = -3970254810918817430L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String ruleCode;
	@Column
	private String ruleValue;
	@Column
	private String ruleDesc;

	public ConvRule() {

	}

	public ConvRule(String ruleCode, String ruleValue, String ruleDesc) {
		super();
		this.ruleCode = ruleCode;
		this.ruleValue = ruleValue;
		this.ruleDesc = ruleDesc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRuleCode() {
		return ruleCode;
	}

	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}

	public String getRuleValue() {
		return ruleValue;
	}

	public void setRuleValue(String ruleCode) {
		this.ruleValue = ruleCode;
	}

	public String getRuleDesc() {
		return ruleDesc;
	}

	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}

	@Override
	public String toString() {
		return ruleCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof ConvRule) {
			ConvRule c = (ConvRule) obj;
			return c.getRuleCode().equals(this.getRuleCode()) && c.getRuleValue().equals(this.getRuleValue());
		}
		return false;
	}

}
