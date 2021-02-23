package com.java.rest.ws.restfulwebservices.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.java.rest.ws.restfulwebservices.dao.InstructorRepository;
import com.java.rest.ws.restfulwebservices.model.Instructor;

@Service
public class InstructorService {
	@Autowired
	private InstructorRepository instructorRepo;

	public List<Instructor> getAllInstructors() {
		return instructorRepo.findAll();
	}

	public Instructor getInstructorById(int id) {
		Instructor instructor = instructorRepo.findById(id).get();
		return instructor;
	}

	public ResponseEntity<Instructor> createInstructor(Instructor instructor) {
		Instructor savedInstructor = instructorRepo.save(instructor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedInstructor.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	public ResponseEntity<Instructor> updateInstructor(int id, Instructor instructor) {
		Instructor updatedInstructor = instructorRepo.save(instructor);
		return new ResponseEntity<Instructor>(updatedInstructor, HttpStatus.OK);
	}

	public ResponseEntity<Void> deleteInstructor(int id) {
		instructorRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}