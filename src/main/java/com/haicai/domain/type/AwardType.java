package com.haicai.domain.type;

import lombok.ToString;

/**
 * Enum: HonoraryTitle("T_AWARD_TYPE_HONORARY_TITLE", 0), Thesis("T_AWARD_TYPE_THESIS", 1), IntellectualProperty("T_AWARD_TYPE_INTELLECTUAL_PROPERTY", 2), Other("T_AWARD_TYPE_OTHER", 3)
 *
 * @author Cain
 *
 */
@ToString
public enum AwardType {
	HonoraryTitle("T_AWARD_TYPE_HONORARY_TITLE", 0), Thesis("T_AWARD_TYPE_THESIS", 1), IntellectualProperty("T_AWARD_TYPE_INTELLECTUAL_PROPERTY", 2), Other("T_AWARD_TYPE_OTHER", 3);

	private String type;
	private int identify;

	private AwardType(String type, int identify) {
		this.type = type;
		this.identify = identify;
	}

	public String getType() {
		return this.type;
	}

	public int getIdentify() {
		return this.identify;
	}

	// from String type to Enum
	public static AwardType getAwardType(String type) {
		switch (type) {
		case "T_AWARD_HONORARY_TITLE":
			return HonoraryTitle;
		case "T_AWARD_THESIS":
			return Thesis;
		case "T_AWARD_INTELLECTUAL_PROPERTY":
			return IntellectualProperty;
		case "T_AWARD_OTHER":
			return Other;
		default:
			return Other;
		}
	}

}
