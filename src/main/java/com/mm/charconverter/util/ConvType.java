package com.mm.charconverter.util;

import com.mm.charconverter.exception.ConvTypeException;

public enum ConvType {
	LAT_TO_CYR, CYR_TO_LAT;

	public static ConvType findByType(String type) throws ConvTypeException {
		for (ConvType t : ConvType.values()) {
			if (t.toString().equals(type)) {
				return t;
			}
		}
		throw new ConvTypeException("Unknown conversion type!");
	}
}
