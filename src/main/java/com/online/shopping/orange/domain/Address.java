package com.online.shopping.orange.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Cain
 *
 */
@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	@Column(name="ID",nullable=false)
	private long id;

	@Getter
	@Setter
	@OneToOne
	private Country country;

	@Getter
	@Setter
	@OneToOne
	private City city;

	@Getter
	@Setter
	@OneToOne
	private District district;

	@Getter
	@Setter
	@Column(name="ZIP_CODE")
	private String zipCode;

	@Getter
	@Setter
	@Column(name="DETAILED_ADDRESS")
	private String detailedAddress;

	@Getter
	@Setter
	@ManyToOne
	private UserAccount userAccount;
}
