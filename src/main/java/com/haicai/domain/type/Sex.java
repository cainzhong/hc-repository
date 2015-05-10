package com.haicai.domain.type;

import lombok.ToString;

/**
 * Enum: FEMALE("FEMALE",0), MALE("MALE",1)
 *
 * @author Cain
 *
 */
@ToString
public enum Sex {
	FEMALE("FEMALE",0), MALE("MALE",1);

	private String sex;
	private int identify;

	private Sex(String sex,int identify) {
		this.sex = sex;
		this.identify=identify;
	}
}
