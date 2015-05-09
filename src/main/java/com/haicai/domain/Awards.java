package com.haicai.domain;

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
@Table(name = "AWARDS")
public class Awards {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private long id;

	/* TYPE ENUM('HONORARY TITLE', 'THESIS', 'INTELLECTUAL PROPERTY','OTHER') */
	@Column(name = "TYPE")
	private AwardsType type;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "REFERRER")
	private String referrer;

	@Column(name = "OTHER")
	private String other;

	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AwardsType getType() {
		return this.type;
	}

	public void setType(AwardsType type) {
		this.type = type;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReferrer() {
		return this.referrer;
	}

	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
