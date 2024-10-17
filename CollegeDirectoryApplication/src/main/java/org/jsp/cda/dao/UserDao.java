package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Department;
import org.jsp.cda.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {

	User saveUser(User u);
	
	Optional<User> findById(int id);

	List<User> findAllUsers();
	
    User updateUser(User u);

	Optional<User> findByUsernameAndPassword(String username, String password);

}
