package com.haicai.domain.type;

import lombok.ToString;

/**
 * Enum: TYPE - Honorary_Title("HONORARY TITLE",0), Thesis("THESIS",1), Intellectual_property("INTELLECTUAL PROPERTY",2), Other("OTHER",3)
 *
 * @author Cain
 *
 */
@ToString
public enum AwardsType {
	HonoraryTitle("HONORARY TITLE",0), Thesis("THESIS",1), IntellectualProperty("INTELLECTUAL PROPERTY",2), Other("OTHER",3);

	private String type;
	private int identify;

	private AwardsType(String type, int identify) {
		this.type = type;
		this.identify=identify;
	}

	public String getType() {
		return this.type;
	}

	public int getIdentify() {
		return this.identify;
	}

}
