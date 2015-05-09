package com.haicai.domain;

import lombok.ToString;

/**
 * @author Cain
 *
 */
@ToString
public enum AwardsType {
	Honorary_Title("HONORARY TITLE"), Thesis("THESIS"), Intellectual_property("INTELLECTUAL PROPERTY"), Other("OTHER");

	String type;

	private AwardsType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
