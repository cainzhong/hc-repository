package com.online.shopping.orange.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "CONTACT_INFO")
public class ContactInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	@Column(name = "ID", nullable = false)
	private long id;

	@Getter
	@Setter
	@Column(name = "TEL_PHONE")
	private String telPhone;

	@Getter
	@Setter
	@Column(name = "FIXED_LINE_TELEPHONE")
	private String fixedLineTelephone;

	@Getter
	@Setter
	@Column(name = "FAX")
	private String fax;

	@Getter
	@Setter
	@Column(name = "EMAIL")
	private String email;

	@Getter
	@Setter
	@ManyToOne
	private UserAccount userAccount;
}
