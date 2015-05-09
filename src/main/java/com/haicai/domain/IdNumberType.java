package com.haicai.domain;

import lombok.ToString;

/**
 * @author Cain
 *
 */
@ToString
public enum IdNumberType {
	Passport("PASSPORT"), IdentityCard("IDENTITY CARD");

	private String idNumberType;

	private IdNumberType(String idNumberType) {
		this.idNumberType = idNumberType;
	}

	public String getIdNumberType() {
		return this.idNumberType;
	}

	public void setIdNumberType(String idNumberType) {
		this.idNumberType = idNumberType;
	}

}
