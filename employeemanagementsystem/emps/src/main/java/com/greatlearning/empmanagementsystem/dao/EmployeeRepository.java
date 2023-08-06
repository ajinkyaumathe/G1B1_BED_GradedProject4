package com.greatlearning.empmanagementsystem.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.empmanagementsystem.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	Set<Employee> findByFirstNameLike(String name);
	
}
