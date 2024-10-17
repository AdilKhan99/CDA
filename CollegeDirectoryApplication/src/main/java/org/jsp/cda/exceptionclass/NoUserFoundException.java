package org.jsp.cda.exceptionclass;

import org.jsp.cda.responsestructure.ResponseStructure.ResponseStructureBuilder;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class NoUserFoundException  extends RuntimeException
{

	private String message;
	public NoUserFoundException(String message)
	{
		this.message = message;
	}
	
	@Override
	public String getMessage() 
	{
		return this.message;
	}

	

}
