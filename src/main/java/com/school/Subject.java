package com.school;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sub")
public class Subject {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="name")
	private String subjectName;
	
	@Column(name="subject_ID")
	private int subjectId;
	
	@Column(name="class_ID")
	private int classId;
	
	
	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(long id, String subjectName, int subjectId) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.subjectId = subjectId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	
	
	
	
}
