package com.haicai.domain.type;

import lombok.ToString;

/**
 * Enum: STATUS - ACTIVE("ACTIVE",0), INACTIVE("INACTIVE",1)
 *
 * @author Cain
 *
 */
@ToString
public enum Status {
	ACTIVE("ACTIVE",0), INACTIVE("INACTIVE",1);

	private String type;
	private int identify;

	private Status(String type, int identify){
		this.type=type;
		this.identify=identify;
	}
}
