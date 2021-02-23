package com.java.rest.ws.restfulwebservices.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.java.rest.ws.restfulwebservices.model.Course;
import com.java.rest.ws.restfulwebservices.model.Student;
import com.java.rest.ws.restfulwebservices.service.CourseService;

@RestController
public class GenericController {
	@Autowired
	CourseService courseService;

	@GetMapping("/listOfCoursesByStudentId/{studentId}")
	public List<Course> listOfCoursesByStudentId(@PathVariable int studentId) {
		return courseService.listOfCoursesByStudentId(studentId);
	}

	@GetMapping("/listOfStudentsByInstructorId/{instructorId}")
	public Set<Student> listOfStudentsByInstructorId(@PathVariable int instructorId) {
		return courseService.listOfStudentsByInstructorId(instructorId);
	}

	@GetMapping("/totalCourseDurationForStudentId/{studentId}")
	public int totalCourseDurationForStudentId(@PathVariable int studentId) {
		return courseService.totalCourseDurationForStudentId(studentId);
	}
}