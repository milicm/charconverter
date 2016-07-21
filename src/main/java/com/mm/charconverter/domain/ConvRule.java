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
	private String ruleFrom;
	@Column
	private String ruleTo;
	@Column
	private String ruleDesc;

	public ConvRule() {
		super();
	}

	public ConvRule(String ruleCode, String ruleFrom, String ruleTo, String ruleDesc) {
		super();
		this.ruleCode = ruleCode;
		this.ruleFrom = ruleFrom;
		this.ruleTo = ruleTo;
		this.ruleDesc = ruleDesc;
	}

	public String getRuleCode() {
		return ruleCode;
	}

	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}

	public String getRuleFrom() {
		return ruleFrom;
	}

	public void setRuleFrom(String ruleFrom) {
		this.ruleFrom = ruleFrom;
	}

	public String getRuleTo() {
		return ruleTo;
	}

	public void setRuleTo(String ruleTo) {
		this.ruleTo = ruleTo;
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
			return c.getRuleCode().equals(this.getRuleCode()) && c.getRuleFrom().equals(this.getRuleFrom())
					&& c.getRuleTo().equals(this.getRuleTo());
		}
		return false;
	}

}
