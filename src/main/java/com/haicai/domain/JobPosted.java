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
@Table(name="JOB_POSTED")
public class JobPosted{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID",nullable=false)
	private int id;

	@Column(name = "TITLE",nullable=false)
	private String title;

	@Column(name = "OFFICE_AREA")
	private String officeArea;

	@Column(name = "SALARY")
	private int salary;

	@Column(name = "AREA_CODE")
	private int areaCode;

	@Column(name = "CONTACT_NUMBER")
	private int contactNumber;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "CONTACT_PERSON")
	private int contactPerson;

	@Column(name = "CONTACT_ADDRESS")
	private int contactAddress;

	/**
	 * A file path will be stored in the database.
	 */
	@Column(name = "JOB_DESC")
	private int jobDesc;

	/**
	 * A file path will be stored in the database.
	 */
	@Column(name = "JOB_REQUIREMENT")
	private int jobRequirement;

	/**
	 * A file path will be stored in the database.
	 */
	@Column(name = "COMPANY_INTRODUCTION")
	private int companyIntroduction;

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

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public int getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(int contactPerson) {
		this.contactPerson = contactPerson;
	}

	public int getContactAddress() {
		return this.contactAddress;
	}

	public void setContactAddress(int contactAddress) {
		this.contactAddress = contactAddress;
	}

	public int getJobDesc() {
		return this.jobDesc;
	}

	/**
	 * A file path will be stored in the database.
	 */
	public void setJobDesc(int jobDesc) {
		this.jobDesc = jobDesc;
	}

	public int getJobRequirement() {
		return this.jobRequirement;
	}

	/**
	 * A file path will be stored in the database.
	 */
	public void setJobRequirement(int jobRequirement) {
		this.jobRequirement = jobRequirement;
	}

	public int getCompanyIntroduction() {
		return this.companyIntroduction;
	}

	/**
	 * A file path will be stored in the database.
	 */
	public void setCompanyIntroduction(int companyIntroduction) {
		this.companyIntroduction = companyIntroduction;
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
