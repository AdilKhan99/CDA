package org.jsp.cda.serviceimpi;

import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DepartmentServiceImpI  implements DepartmentService{
	
	
	@Autowired
	private DepartmentDao departmentdao;

	@Override
	public ResponseEntity<?> saveDepartment(Department d) 
	{
	d = departmentdao.saveDepartment(d);
	
		return ResponseEntity.status(HttpStatus.OK)
				.body(ResponseStructure
						.builder()
						.status(HttpStatus.OK.value())
						.message("Department Registered Sucessufully...")
						.body(d)
						.build()
						);
	}

}
