package com.haicai.domain;

import lombok.ToString;

@ToString
public enum UniversityDegree {
	Bachelor("BACHELOR"), Master("MASTER"), Doctor("DOCTOR"), PostDoctor("POST-DOCTOR"), Other("OTHER");

	private String degree;

	private UniversityDegree(String degree) {
		this.degree = degree;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

}
