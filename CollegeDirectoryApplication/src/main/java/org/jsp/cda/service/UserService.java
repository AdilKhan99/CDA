package org.jsp.cda.service;

import org.jsp.cda.entity.User;
import org.jsp.cda.util.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

	ResponseEntity<?> saveUser(User u);

	ResponseEntity<?> findAllUser();

	ResponseEntity<?> findUserById(int id);

	ResponseEntity<?> updateUser(int id, User u);

	ResponseEntity<?> deleteUser();

	ResponseEntity<?> login(AuthUser authUser);

	


	
	

}
