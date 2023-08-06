package com.greatlearning.empmanagementsystem.service;

import java.util.List;
import java.util.Set;

import com.greatlearning.empmanagementsystem.model.Employee;

public interface EmployeeService {
	
	Employee save(Employee employee);
	
	Set<Employee> fetchAll();
	
	Employee findById(long id);
	
	void deleteById(long id);
	
	
	Set<Employee> fetchEmployeesByName(String name);
	
	List<Employee> findByFirstNameSorted(String order);

}
