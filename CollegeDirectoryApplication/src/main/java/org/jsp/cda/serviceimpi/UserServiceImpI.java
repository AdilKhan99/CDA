package org.jsp.cda.serviceimpi;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.User;
import org.jsp.cda.exceptionclass.InvalidCredentialsException;
import org.jsp.cda.exceptionclass.NoUserFoundException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.UserService;
import org.jsp.cda.util.AuthUser;
import org.jsp.cda.util.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpI  implements UserService{
	
	@Autowired
	private UserDao userdao;

	@Override
	public ResponseEntity<?> saveUser(User u) {
	u.setStatus(UserStatus.IN_ACTIVE);
	u = userdao.saveUser(u);
	
		return ResponseEntity.status(HttpStatus.OK)
				.body(ResponseStructure
						.builder()
						.status(HttpStatus.OK.value())
						.message("User Registered Sucessufully...")
						.body(u)
						.build()
						);
	}

	@Override
	public ResponseEntity<?> findAllUser() {
		List<User> ul = userdao.findAllUsers();
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		if (ul.isEmpty())
			throw NoUserFoundException.builder().message("No User Found In The Database Table").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("All User Found Successfully").body(ul).build());

	}

	@Override
	public ResponseEntity<?> findUserById(int id) {
		Optional<User> userOptional = userdao.findById(id);
		if (userOptional.isPresent()) {
	        User user = userOptional.get();
	        
	        // Build the successful response with the found user
	        return ResponseEntity.status(HttpStatus.OK)
	                .body(ResponseStructure
	                        .builder()
	                        .status(HttpStatus.OK.value())
	                        .message("User found successfully")
	                        .body(user)
	                        .build()
	                );
	    } else {
	        // If the user is not found, return an appropriate response
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body(ResponseStructure
	                        .builder()
	                        .status(HttpStatus.NOT_FOUND.value())
	                        .message("User not found")
	                        .body(null)
	                        .build()
	                );
	    }
		

	}

	@Override
	public ResponseEntity<?> updateUser(int id, User u) {
	    // Check if the user exists by ID
	    Optional<User> existingUserOptional = userdao.findById(id);

	    if (existingUserOptional.isPresent()) {
	        User existingUser = existingUserOptional.get();

	        // Update the fields of the existing user with the new data
	        if (u.getName() != null) existingUser.setName(u.getName());
	        if (u.getEmail() != null) existingUser.setEmail(u.getEmail());
	        if (u.getStatus() != null) existingUser.setStatus(u.getStatus());
	        // Update other fields as needed (e.g., phone, address, etc.)

	        // Optionally, set a status like IN_ACTIVE, as in your original logic
	        existingUser.setStatus(UserStatus.IN_ACTIVE);

	        // Save the updated user back to the database
	        userdao.saveUser(existingUser);

	        // Return a success response with the updated user
	        return ResponseEntity.status(HttpStatus.OK)
	                .body(ResponseStructure
	                        .builder()
	                        .status(HttpStatus.OK.value())
	                        .message("User updated successfully")
	                        .body(existingUser)
	                        .build()
	                );
	    } else {
	        // If the user with the specified ID does not exist, return a NOT_FOUND response
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body(ResponseStructure
	                        .builder()
	                        .status(HttpStatus.NOT_FOUND.value())
	                        .message("User not found")
	                        .body(null)
	                        .build()
	                );
	    }
	}


	@Override
	public ResponseEntity<?> deleteUser() {
		return null;
	}

	@Override
	public ResponseEntity<?> login(AuthUser authUser) {
	  String username = authUser.getUsername();
	  String password = authUser.getPassword();
	  
	 Optional<User> optional = userdao.findByUsernameAndPassword(username,password);
	 
	 if(optional.isEmpty())
		 throw new InvalidCredentialsException("Invalid Username or Password");
//		 throw InvalidCredentialsException.builder().message("Invalid Username or Password").build();
	  
	 	User user = optional.get();
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("user verification successfully").body(user).build());
	}

	



	
	
	
	
	
	

}
