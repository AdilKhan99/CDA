package org.jsp.cda.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.User;
import org.jsp.cda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImpI implements UserDao{
	
	@Autowired
	private UserRepository userrepositor;

	@Override
	public User saveUser(User u) {
		return userrepositor.save(u);
	}
	
	@Override
	public Optional<User> findById(int id) {
		return userrepositor.findById(id);
	}

	@Override
	public List<User> findAllUsers() {
		return userrepositor.findAll();
	}

	

	@Override
	public User updateUser(User u) {
		return userrepositor.save(u);
	}

	@Override
	public Optional<User> findByUsernameAndPassword(String username, String password) {

		return userrepositor.findByUsernameAndPassword(username,password);
	}
	

}
