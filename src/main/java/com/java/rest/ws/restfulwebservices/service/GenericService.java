package com.java.rest.ws.restfulwebservices.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.rest.ws.restfulwebservices.dao.CourseRepository;
import com.java.rest.ws.restfulwebservices.model.Course;
import com.java.rest.ws.restfulwebservices.model.Student;

@Service
public class GenericService {
	@Autowired
	private CourseRepository courseRepo;

	public List<Course> listOfCoursesByStudentId(int studentId) {
		List<Course> courses = courseRepo.findAllById(studentId);
		return courses;
	}

	public Set<Student> listOfStudentsByInstructorId(int instructorId) {
		Set<Student> students = courseRepo.findAllStudentsByInstuctorById(instructorId);
		return students;
	}

	public int totalCourseDurationForStudentId(int studentId) {
		List<Course> courses = courseRepo.findAllById(studentId);
		int totalDuration = courses.stream().map(course -> course.getDuration()).reduce(0,(sum, duration) -> sum+duration);
		return totalDuration;
	}
}