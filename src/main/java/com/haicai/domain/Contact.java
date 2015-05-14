package com.haicai.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.haicai.domain.type.ContactType;

/**
 * @author Cain
 *
 */
@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "CONTACT")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private int id;

	@Column(name="INFO")
	private String info;

	@Enumerated(EnumType.ORDINAL)
	@Column(name="TYPE")
	private ContactType type;

	@Column(name="OTHER_DESCRIPTION")
	private String otherDdescription;

	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

	@Column(name="CREATE_TIME")
	private Timestamp createTime;

	@Column(name="UPDATE_TIME")
	private Timestamp updateTime;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public ContactType getType() {
		return this.type;
	}

	/**
	 * EMAIL("EMAIL",0), TELEPHONE("TELEPHONE",1), OTHER("OTHER",2)
	 *
	 * @param type
	 */
	public void setType(ContactType type) {
		this.type = type;
	}

	public String getOtherDdescription() {
		return this.otherDdescription;
	}

	public void setOtherDdescription(String otherDdescription) {
		this.otherDdescription = otherDdescription;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
}
