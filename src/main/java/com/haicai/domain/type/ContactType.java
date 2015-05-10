package com.haicai.domain.type;

import lombok.ToString;

/**
 * Enum: EMAIL("EMAIL",0), TELEPHONE("TELEPHONE",1), OTHER("OTHER",2)
 *
 * @author Cain
 *
 */
@ToString
public enum ContactType {
	EMAIL("EMAIL",0), TELEPHONE("TELEPHONE",1), OTHER("OTHER",2);

	private String type;
	private int identify;

	private ContactType(String type,int identify) {
		this.type = type;
		this.identify=identify;
	}

}
