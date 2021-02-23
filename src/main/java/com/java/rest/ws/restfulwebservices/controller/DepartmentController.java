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

import com.java.rest.ws.restfulwebservices.model.Department;
import com.java.rest.ws.restfulwebservices.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/departments")
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

	@GetMapping("/departments/{departmentName}")
	public Department getDepartmentByName(@PathVariable String departmentName) {
		return departmentService.getDepartmentByName(departmentName);
	}

	@PostMapping("/departments")
	public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
		return departmentService.createDepartment(department);
	}

	@PutMapping("/departments/{name}")
	public ResponseEntity<Department> updateDepartment(@PathVariable String name, @RequestBody Department department) {
		return departmentService.updateDepartment(name, department);
	}

	@DeleteMapping("/departments/{name}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable String name) {
		return departmentService.deleteDepartment(name);
	}
}