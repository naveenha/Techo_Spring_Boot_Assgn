package com.java.rest.ws.restfulwebservices.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.java.rest.ws.restfulwebservices.dao.StudentRepository;
import com.java.rest.ws.restfulwebservices.model.Student;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepo;

	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	public Student getStudentById(int id) {
		Student student = studentRepo.findById(id).get();
		return student;
	}

	public ResponseEntity<Student> createStudent(Student student) {
		Student savedStudent = studentRepo.save(student);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedStudent.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	public ResponseEntity<Student> updateStudent(int id, Student student) {
		Student updatedStudent = studentRepo.save(student);
		return new ResponseEntity<Student>(updatedStudent, HttpStatus.OK);
	}

	public ResponseEntity<Void> deleteStudent(int id) {
		studentRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}