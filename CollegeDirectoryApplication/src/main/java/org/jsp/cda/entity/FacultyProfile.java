package org.jsp.cda.entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FacultyProfile{
	
	@OneToOne 
    @MapsId
    @Id
	private User user_id;
	private String  photo;
	@ManyToOne
	private Department department;
	
	private LocalTime office_hours;
	

	
	
	

}
