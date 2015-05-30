package com.haicai.domain.type;

import lombok.ToString;

/**
 * Enum: Bachelor("T_UNIVERSITY_DEGREE_BACHELOR", 0), Master("T_UNIVERSITY_DEGREE_MASTER", 1), Doctor("T_UNIVERSITY_DEGREE_DOCTOR", 2), PostDoctor("T_UNIVERSITY_DEGREE_POSTDOCTOR", 3), Other("T_UNIVERSITY_DEGREE_OTHER", 4)
 *
 * @author Cain
 *
 */
@ToString
public enum UniversityDegree {
	Bachelor("T_UNIVERSITY_DEGREE_BACHELOR", 0), Master("T_UNIVERSITY_DEGREE_MASTER", 1), Doctor("T_UNIVERSITY_DEGREE_DOCTOR", 2), PostDoctor("T_UNIVERSITY_DEGREE_POSTDOCTOR", 3), Other("T_UNIVERSITY_DEGREE_OTHER", 4);

	private String degree;
	private int identify;

	private UniversityDegree(String degree, int identify) {
		this.degree = degree;
		this.identify = identify;
	}

	public String getDegree() {
		return this.degree;
	}

	public int getIdentify() {
		return this.identify;
	}

	// from String degree to Enum
	public static UniversityDegree getUniversityDegree(String degree) {
		switch (degree) {
		case "T_UNIVERSITY_DEGREE_BACHELOR":
			return Bachelor;
		case "T_UNIVERSITY_DEGREE_MASTER":
			return Master;
		case "T_UNIVERSITY_DEGREE_DOCTOR":
			return Doctor;
		case "T_UNIVERSITY_DEGREE_POSTDOCTOR":
			return PostDoctor;
		case "T_UNIVERSITY_DEGREE_OTHER":
			return Other;
		default:
			return Other;
		}
	}

}
