package com.haicai.domain.type;

import lombok.ToString;

/**
 * Enum: UNIVERSITY_DEGREE - Bachelor("BACHELOR",0), Master("MASTER",1), Doctor("DOCTOR",2), PostDoctor("POST-DOCTOR",3), Other("OTHER",4)
 *
 * @author Cain
 *
 */
@ToString
public enum UniversityDegree {
	Bachelor("BACHELOR",0), Master("MASTER",1), Doctor("DOCTOR",2), PostDoctor("POST-DOCTOR",3), Other("OTHER",4);

	private String degree;
	private int identify;

	private UniversityDegree(String degree,int identify) {
		this.degree = degree;
		this.identify=identify;
	}

	public String getDegree() {
		return this.degree;
	}

	public int getIdentify() {
		return this.identify;
	}
}
