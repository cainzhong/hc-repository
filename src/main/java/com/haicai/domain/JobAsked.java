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
@Table(name="JOB_ASKED")
public class JobAsked {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID",nullable=false)
	private int id;

	@Column(name = "PRO_FIELD",nullable=false)
	private String proField;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "OFFICE_AREA")
	private String officeArea;

	@Column(name = "WORK_TIME_TYPE")
	private int workTimeType;

	@Column(name = "EXPECT_SALARY")
	private String expectSalary;

	@Column(name = "REQUIREMENT")
	private String requirement;

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

	public String getProField() {
		return this.proField;
	}

	public void setProField(String proField) {
		this.proField = proField;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOfficeArea() {
		return this.officeArea;
	}

	public void setOfficeArea(String officeArea) {
		this.officeArea = officeArea;
	}

	public int getWorkTimeType() {
		return this.workTimeType;
	}

	public void setWorkTimeType(int workTimeType) {
		this.workTimeType = workTimeType;
	}

	public String getExpectSalary() {
		return this.expectSalary;
	}

	public void setExpectSalary(String expectSalary) {
		this.expectSalary = expectSalary;
	}

	public String getRequirement() {
		return this.requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
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
