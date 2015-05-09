package com.haicai.domain;

import lombok.ToString;

/**
 * @author Cain
 *
 */
@ToString
public enum Sex {
	Female("FEMALE"), Male("MALE");

	private String sex;

	private Sex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
