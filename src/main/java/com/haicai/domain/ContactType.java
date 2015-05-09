package com.haicai.domain;

import lombok.ToString;

/**
 * @author Cain
 *
 */
@ToString
public enum ContactType {
	Email("EMAIL"), Telephone("TELEPHONE"), Other("OTHER");

	private String type;

	private ContactType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
