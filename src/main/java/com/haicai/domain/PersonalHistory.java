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
@Table(name = "PERSONALHISTORY")
public class PersonalHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private long id;

	@Column(name = "UNIVERSITY")
	private String university;

	/* UNIVERSITY_DEGREE ENUM('BACHELOR','MASTER','DOCTOR','POST-DOCTOR','OTHER') */
	@Column(name = "UNIVERSITY_DEGREE")
	private UniversityDegree universityDegree;

	@Column(name = "GRADUATION_YEAR")
	private String graduationYear;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
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

	public void setUniversityDegree(UniversityDegree universityDegree) {
		this.universityDegree = universityDegree;
	}

	public String getGraduationYear() {
		return this.graduationYear;
	}

	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}
}
