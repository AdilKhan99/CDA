package org.jsp.cda.service;

import org.jsp.cda.entity.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface DepartmentService {

	ResponseEntity<?> saveDepartment(Department d);
	

}
