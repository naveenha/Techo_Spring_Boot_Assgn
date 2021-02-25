package com.java.rest.ws.restfulwebservices.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.java.rest.ws.restfulwebservices.dao.CourseRepository;
import com.java.rest.ws.restfulwebservices.model.Course;
import com.java.rest.ws.restfulwebservices.model.Student;

@ExtendWith(MockitoExtension.class)
public class GenericServiceTest {
	@InjectMocks
	private GenericService service;

	@Mock
	private CourseRepository courseRepo;

	@Test
	public void listOfCoursesByStudentId_basic() {
		when(courseRepo.findAllById(10)).thenReturn(Arrays.asList(new Course(1, "SpringBoot"), new Course(2, "MicroService")));
		List<Course> courses = service.listOfCoursesByStudentId(10);

		assertEquals(1, courses.get(0).getDuration());
		assertEquals(2, courses.get(1).getDuration());
	}

	@Test
	public void listOfStudentsByInstructorId_basic() {
		Set<Student> set = new HashSet<Student>();
		set.add(new Student("Naveen", "Kumar", "123456"));
		set.add(new Student("John", "Doe", "987654"));
		when(courseRepo.findAllStudentsByInstuctorById(100)).thenReturn(set);
		Set<Student> students = service.listOfStudentsByInstructorId(100);

		assertEquals(set, students);
	}

	@Test
	public void totalCourseDurationForStudentId_basic() {
		when(courseRepo.findAllById(10)).thenReturn(Arrays.asList(new Course(1, "SpringBoot"), new Course(2, "MicroService")));
		int totalDuration = service.totalCourseDurationForStudentId(10);

		assertEquals(3, totalDuration);
	}
}