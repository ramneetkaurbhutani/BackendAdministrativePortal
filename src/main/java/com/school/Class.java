package com.school;


import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CollectionType;
import org.hibernate.annotations.ManyToAny;




@Entity
@Table(name="class")
public class Class {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long classId;
	
	@Column(name="name")
	private String className;
	
	
	@Cascade(CascadeType.ALL)@OneToMany(mappedBy = "classId")
	private List<Subject> subjects;
	
	
	@Cascade(CascadeType.ALL)@OneToMany(mappedBy = "classId")
	private List<Student> students;
	
	
	@Cascade(CascadeType.ALL)@OneToMany(mappedBy = "classId")
	private List<Teacher> teachers;

	public Class(long classId, String className, List<Subject> subjects, List<Student> students,
			List<Teacher> teachers) {
		super();
		this.classId = classId;
		this.className = className;
		this.subjects = subjects;
		this.students = students;
		this.teachers = teachers;
	}

	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getClassId() {
		return classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
}
