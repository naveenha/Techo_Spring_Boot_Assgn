package com.java.rest.ws.restfulwebservices.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.java.rest.ws.restfulwebservices.dao.DepartmentRepository;
import com.java.rest.ws.restfulwebservices.model.Department;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepo;

	public List<Department> getAllDepartments() {
		return departmentRepo.findAll();
	}

	public Department getDepartmentByName(String name) {
		Department department = departmentRepo.findById(name).get();
		return department;
	}

	public ResponseEntity<Department> createDepartment(Department department) {
		Department savedDepartment = departmentRepo.save(department);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedDepartment.getName()).toUri();
		return ResponseEntity.created(uri).build();
	}

	public ResponseEntity<Department> updateDepartment(String name, Department department) {
		Department updatedDepartment = departmentRepo.save(department);
		return new ResponseEntity<Department>(updatedDepartment, HttpStatus.OK);
	}

	public ResponseEntity<Void> deleteDepartment(String name) {
		departmentRepo.deleteById(name);
		return ResponseEntity.noContent().build();
	}
}