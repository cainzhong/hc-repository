package com.haicai.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.haicai.domain.type.UniversityDegree;

/**
 * @author Cain
 *
 */
@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "PERSONAL_HISTORY")
public class PersonalHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private int id;

	@Column(name = "UNIVERSITY")
	private String university;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "UNIVERSITY_DEGREE")
	private UniversityDegree universityDegree;

	@Column(name = "GRADUATION_YEAR")
	private String graduationYear;

	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUniversity() {
		return this.university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public UniversityDegree getUniversityDegree() {
		return this.universityDegree;
	}

	/**
	 * Bachelor("BACHELOR",0), Master("MASTER",1), Doctor("DOCTOR",2), PostDoctor("POST-DOCTOR",3), Other("OTHER",4)
	 *
	 * @param universityDegree
	 */
	public void setUniversityDegree(UniversityDegree universityDegree) {
		this.universityDegree = universityDegree;
	}

	public String getGraduationYear() {
		return this.graduationYear;
	}

	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
