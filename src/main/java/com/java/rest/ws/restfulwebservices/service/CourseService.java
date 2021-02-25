package com.java.rest.ws.restfulwebservices.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.java.rest.ws.restfulwebservices.dao.CourseRepository;
import com.java.rest.ws.restfulwebservices.model.Course;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepo;

	public List<Course> getAllCourses() {
		return courseRepo.findAll();
	}

	public Course getCourseById(int id) {
		Course course =  courseRepo.findById(id).get();
		return course;
	}

	public ResponseEntity<Course> createCourse(Course course) {
		Course savedCourse = courseRepo.save(course);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCourse.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	public ResponseEntity<Course> updateCourse(int id, Course course) {
		Course updatedCourse = courseRepo.save(course);
		return new ResponseEntity<Course>(updatedCourse, HttpStatus.OK);
	}

	public ResponseEntity<Void> deleteCourse(int id) {
		courseRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}