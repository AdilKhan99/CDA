package org.jsp.cda.controller;

import org.jsp.cda.entity.User;
import org.jsp.cda.service.UserService;
import org.jsp.cda.util.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/users")
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User u)
	{
		return service.saveUser(u);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthUser authUser)
	{
		return service.login(authUser);
	}
	
	
	
	
	
	
	
	
	
	
	
	
    
	@GetMapping
	public ResponseEntity<?> findAllUser()
	{
		return service.findAllUser();
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> findUserById(@PathVariable int id)
	{
		return service.findUserById(id);
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User u) 
	{
	    return service.updateUser(id, u);
	}

	
	@DeleteMapping
	public ResponseEntity<?> deleteUser(@RequestParam int id)
	{
		return service.deleteUser();
	}
	
	
	

}
