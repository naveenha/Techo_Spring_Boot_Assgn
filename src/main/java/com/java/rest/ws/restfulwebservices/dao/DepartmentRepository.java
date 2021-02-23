package com.java.rest.ws.restfulwebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.rest.ws.restfulwebservices.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
}