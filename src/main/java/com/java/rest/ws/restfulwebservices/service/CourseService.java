package com.java.rest.ws.restfulwebservices.service;

import java.net.URI;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.java.rest.ws.restfulwebservices.dao.CourseRepository;
import com.java.rest.ws.restfulwebservices.model.Course;
import com.java.rest.ws.restfulwebservices.model.Student;

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