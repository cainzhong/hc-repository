 /**
 *@Project: hc-repository
 *
 *@Date: 2015年5月14日
 *@Copyright: 2015 sg.nomaka.tk Inc. All rights reserved.
 */
package com.haicai.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Cain
 *
 */
@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="ENTERPRISE_DETAIL")
public class EnterpriseDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID",nullable=false)
	private int id;

	/**
	 * A file path will be stored in the database.
	 */
	@Column(name = "ORATION")
	private String oration;

	/**
	 * A file path will be stored in the database.
	 */
	@Column(name = "INTRODUCTION")
	private String introduction;

	/**
	 * A file path will be stored in the database.
	 */
	@Column(name = "ADVANTAGE")
	private String advantage;

	/**
	 * A file path will be stored in the database.
	 */
	@Column(name = "PROVIDE")
	private String provide;

	/**
	 * A file path will be stored in the database.
	 */
	@Column(name = "OTHER")
	private String other;

	@ManyToOne(fetch=FetchType.LAZY)
	private Enterprise enterprise;

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

	public String getOration() {
		return this.oration;
	}

	/**
	 * A file path will be stored in the database.
	 */
	public void setOration(String oration) {
		this.oration = oration;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	/**
	 * A file path will be stored in the database.
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getAdvantage() {
		return this.advantage;
	}

	/**
	 * A file path will be stored in the database.
	 */
	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}

	public String getProvide() {
		return this.provide;
	}

	/**
	 * A file path will be stored in the database.
	 */
	public void setProvide(String provide) {
		this.provide = provide;
	}

	public String getOther() {
		return this.other;
	}

	/**
	 * A file path will be stored in the database.
	 */
	public void setOther(String other) {
		this.other = other;
	}

	public Enterprise getEnterprise() {
		return this.enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
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
