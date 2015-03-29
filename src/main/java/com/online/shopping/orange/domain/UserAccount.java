package com.online.shopping.orange.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "USER_ACCOUNT")
public class UserAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter
	@Setter
	@Column(name = "ID",nullable=false)
	private long id;

	@Getter
	@Setter
	@Column(name = "USERNAME",unique=true,nullable=false)
	private String username;

	@Getter
	@Setter
	@Column(name = "PASSWORD")
	private String password;

}
