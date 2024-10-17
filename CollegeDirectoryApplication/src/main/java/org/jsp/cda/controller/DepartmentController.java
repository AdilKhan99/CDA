package org.jsp.cda.controller;

import org.jsp.cda.entity.Department;
import org.jsp.cda.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentservice;
	
	@PostMapping
	public ResponseEntity<?> saveDepartment(@RequestBody Department department)
	{
		
	
		return departmentservice.saveDepartment(department);
	}
	

}
