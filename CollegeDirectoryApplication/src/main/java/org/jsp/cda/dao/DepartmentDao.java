package org.jsp.cda.dao;

import org.jsp.cda.entity.Department;
import org.springframework.stereotype.Component;

@Component
public interface DepartmentDao {

	Department saveDepartment(Department d);
	

}
