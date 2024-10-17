package org.jsp.cda.userexceptionhandler;

import org.jsp.cda.exceptionclass.InvalidCredentialsException;
import org.jsp.cda.exceptionclass.NoUserFoundException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler 
{
	@ExceptionHandler(NoUserFoundException.class)
	public ResponseEntity<?> noUserFoundExceptionHandler(NoUserFoundException e) 
	{
//		ResponseStructure<String> structure = new ResponseStructure<String>();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder()
				.status(HttpStatus.NOT_FOUND.value()).message("No User Found").body(e.getMessage()).build());
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<?> invalidCredentialsException(InvalidCredentialsException e) 
	{
//		ResponseStructure<String> structure = new ResponseStructure<String>();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder()
				.status(HttpStatus.BAD_REQUEST.value()).message("Invalid Credentials...").body(e.getMessage()).build());
	}

	

}
