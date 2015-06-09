package com.haicai.domain.type;

import lombok.ToString;

/**
 * Enum: FullTime("T_INDIVIDUAL_POSITION_WORK_TIME_TYPE_FULL_TIME=", 0), PartTime("T_INDIVIDUAL_POSITION_WORK_TIME_TYPE_PART_TIME=", 1)
 *
 * @author Cain
 *
 */
@ToString
public enum WorkTimeType {
	FullTime("T_INDIVIDUAL_POSITION_WORK_TIME_TYPE_FULL_TIME", 0), PartTime("T_INDIVIDUAL_POSITION_WORK_TIME_TYPE_PART_TIME", 1);

	private String type;
	private int identify;

	private WorkTimeType(String type, int identify) {
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
	public static WorkTimeType getAwardType(String type) {
		switch (type) {
		case "T_INDIVIDUAL_POSITION_WORK_TIME_TYPE_FULL_TIME":
			return FullTime;
		case "T_INDIVIDUAL_POSITION_WORK_TIME_TYPE_PART_TIME":
			return PartTime;
		default:
			return FullTime;
		}
	}

}
