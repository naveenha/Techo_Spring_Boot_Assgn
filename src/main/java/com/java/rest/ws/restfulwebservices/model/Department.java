package com.java.rest.ws.restfulwebservices.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Department {
	@Id
	private String name;

	private String location;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="department", cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JsonIgnore
	private List<Instructor> instructor;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="department", cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JsonIgnore
	private List<Course> courses;

	public Department() {
	}

	public Department(String location) {
		super();
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Instructor> getInstructor() {
		return instructor;
	}
	public void setInstructor(List<Instructor> instructor) {
		this.instructor = instructor;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}