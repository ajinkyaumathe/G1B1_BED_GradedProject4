package com.greatlearning.empmanagementsystem.model;

import java.time.LocalDate;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Data
@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    private String firstName;

    private String lastName;

    private String email;

	
	public Employee(String firstName, String lastName, String email){
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
	}
    
}
