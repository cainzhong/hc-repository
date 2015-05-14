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
@Table(name="MEDIA")
public class Media {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID",nullable=false)
	private int id;

	/**
	 * A file path will be stored in the database.
	 */
	@Column(name = "VIDEO")
	private String video;

	/**
	 * A file path will be stored in the database.
	 */
	@Column(name = "VIDEO_DESC")
	private String video_desc;

	/**
	 * A file path will be stored in the database.
	 */
	@Column(name = "PICTURE")
	private String picture;

	/**
	 * A file path will be stored in the database.
	 */
	@Column(name = "PICTURE_DESC")
	private String pictureDesc;

	@ManyToOne(fetch=FetchType.LAZY)
	private EnterpriseDetail enterpriseDetail;

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

	public String getVideo() {
		return this.video;
	}

	/**
	 * A file path will be stored in the database.
	 */
	public void setVideo(String video) {
		this.video = video;
	}

	public String getVideo_desc() {
		return this.video_desc;
	}

	/**
	 * A file path will be stored in the database.
	 */
	public void setVideo_desc(String video_desc) {
		this.video_desc = video_desc;
	}

	public String getPicture() {
		return this.picture;
	}

	/**
	 * A file path will be stored in the database.
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPictureDesc() {
		return this.pictureDesc;
	}

	/**
	 * A file path will be stored in the database.
	 */
	public void setPictureDesc(String pictureDesc) {
		this.pictureDesc = pictureDesc;
	}

	public EnterpriseDetail getEnterpriseDetail() {
		return this.enterpriseDetail;
	}

	public void setEnterpriseDetail(EnterpriseDetail enterpriseDetail) {
		this.enterpriseDetail = enterpriseDetail;
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
