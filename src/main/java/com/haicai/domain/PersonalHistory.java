package com.haicai.domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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

	@Column(name="MAJOR")
	private String major;

	@Column(name = "GRADUATION_YEAR")
	private Timestamp graduationYear;

	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

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

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGraduationYear() {
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy");
		return sdf.format(this.graduationYear);
	}

	public void setGraduationYear(Object graduationYear) {
		if(graduationYear instanceof String){
			String timeSuffix = "-07-01 00:00:00";
			this.graduationYear = Timestamp.valueOf(graduationYear+timeSuffix);
		}else if (graduationYear instanceof Timestamp) {
			this.graduationYear = (Timestamp) graduationYear;
		}

	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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
