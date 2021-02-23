package com.java.rest.ws.restfulwebservices.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.rest.ws.restfulwebservices.model.Course;
import com.java.rest.ws.restfulwebservices.model.Student;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	@Query("select c from Course c join c.students s where s.id = ?1")
	public List<Course> findAllById(int id);

	@Query("select s from Student s join s.courses sc join sc.instructor i where i.id = ?1")
	public Set<Student> findAllStudentsByInstuctorById(int id);
}