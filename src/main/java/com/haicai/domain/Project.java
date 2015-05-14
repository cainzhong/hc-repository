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
@Table(name="PROJECT")
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID",nullable=false)
	private int id;

	@Column(name = "NAME",nullable=false)
	private String name;

	/**
	 * A file path will be stored in the database.
	 */
	@Column(name = "SUMMARY",nullable=false)
	private String summary;

	/**
	 * A file path will be stored in the database.
	 */
	@Column(name = "ATTACHMENT")
	private String attachment;

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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return this.summary;
	}

	/**
	 * A file path will be stored in the database.
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAttachment() {
		return this.attachment;
	}

	/**
	 * A file path will be stored in the database.
	 */
	public void setAttachment(String attachment) {
		this.attachment = attachment;
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
