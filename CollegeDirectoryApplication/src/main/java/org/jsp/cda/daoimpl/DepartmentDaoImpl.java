package org.jsp.cda.daoimpl;

import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentDaoImpl implements DepartmentDao{

    @Autowired
    DepartmentRepository departmentrepository;
    
	
	
	@Override
	public Department saveDepartment(Department d) {
		return departmentrepository.save(d);
	}
	

}
