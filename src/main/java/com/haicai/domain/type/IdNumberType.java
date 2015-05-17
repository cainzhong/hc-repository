package com.haicai.domain.type;

import lombok.ToString;

/**
 * Enum: ID_NUMBER_TYPE - PASSPORT("PASSPORT",0), IDENTITYCARD("IDENTITY CARD",1)
 *
 * @author Cain
 *
 */
@ToString
public enum IdNumberType {
	PASSPORT("PASSPORT",0), IDENTITYCARD("IDENTITY CARD",1);

	private String idNumberType;
	private int identify;

	private IdNumberType(String idNumberType,int identify) {
		this.idNumberType = idNumberType;
		this.identify=identify;
	}

	public String getIdNumberType() {
		return this.idNumberType;
	}

	public int getIdentify() {
		return this.identify;
	}
}
