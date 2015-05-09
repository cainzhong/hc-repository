package com.haicai.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "USER")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID",nullable=false)
	private long id;

	@Column(name = "USERNAME",unique=true,nullable=false)
	private String username;

	@Column(name = "REAL_NAME")
	private String realName;

	@Column(name = "ENGLISH_NAME")
	private String englishName;

	@Column(name = "PASSWORD")
	private String password;

	/* SEX ENUM('FEMALE','MALE') */
	@Column(name = "SEX")
	private Sex SEX;

	@Column(name = "ID_NUMBER")
	private String idNumber;

	/* ID_NUMBER_TYPE ENUM('PASSPORT','IDENTITY CARD') */
	@Column(name = "ID_NUMBER_TYPE")
	private IdNumberType idNumberType;

	@Column(name = "CURRENT_COUNTRY")
	private String currentCountry;

	@Column(name = "CURRENT_CITY")
	private String currentCity;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEnglishName() {
		return this.englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Sex getSEX() {
		return this.SEX;
	}

	public void setSEX(Sex sEX) {
		this.SEX = sEX;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public IdNumberType getIdNumberType() {
		return this.idNumberType;
	}

	public void setIdNumberType(IdNumberType idNumberType) {
		this.idNumberType = idNumberType;
	}

	public String getCurrentCountry() {
		return this.currentCountry;
	}

	public void setCurrentCountry(String currentCountry) {
		this.currentCountry = currentCountry;
	}

	public String getCurrentCity() {
		return this.currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

}
