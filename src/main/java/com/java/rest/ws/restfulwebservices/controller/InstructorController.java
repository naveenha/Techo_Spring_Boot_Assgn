package com.java.rest.ws.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.rest.ws.restfulwebservices.model.Instructor;
import com.java.rest.ws.restfulwebservices.service.InstructorService;

@RestController
public class InstructorController {
	@Autowired
	private InstructorService instructorService;

	@GetMapping("/instructors")
	public List<Instructor> getAllInstructors() {
		return instructorService.getAllInstructors();
	}

	@GetMapping("/instructors/{instructorId}")
	public Instructor getInstructorById(@PathVariable int instructorId) {
		return instructorService.getInstructorById(instructorId);
	}

	@PostMapping("/instructors")
	public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
		return instructorService.createInstructor(instructor);
	}

	@PutMapping("/instructors/{id}")
	public ResponseEntity<Instructor> updateInstructor(@PathVariable int id, @RequestBody Instructor instructor) {
		return instructorService.updateInstructor(id, instructor);
	}

	@DeleteMapping("/instructors/{id}")
	public ResponseEntity<Void> deleteInstructor(@PathVariable int id) {
		return instructorService.deleteInstructor(id);
	}
}