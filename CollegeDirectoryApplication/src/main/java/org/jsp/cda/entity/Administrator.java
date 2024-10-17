package org.jsp.cda.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Administrator{
	@OneToOne 
    @MapsId
    @Id
	private User user_id;
	private String photo;
	@ManyToOne
	private Department department;

}
