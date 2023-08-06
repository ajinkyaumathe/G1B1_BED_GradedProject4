package com.greatlearning.empmanagementsystem.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.empmanagementsystem.model.Employee;
import com.greatlearning.empmanagementsystem.service.EmployeeService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	@ApiResponses({
	@ApiResponse(
			description = "Fetches all the employees",
			responseCode = "200"),
	@ApiResponse(
			description = "You are not authenticated user",
			responseCode = "401"),
	@ApiResponse(
			description = "You are not authorized user",
			responseCode = "403")
	})
	public Set<Employee> fetchEmployees(){
		return this.employeeService.fetchAll();
	}
	
	@GetMapping("/{id}")
	@ApiResponses({
	@ApiResponse(
			description = "Fetches the employee with the id passed",
			responseCode = "200"),
	@ApiResponse(
			description = "You are not authenticated user",
			responseCode = "401"),
	@ApiResponse(
			description = "You are not authorized user",
			responseCode = "403")
	})
	public Employee findEmployeeById(@PathVariable("id") long id) {
		return this.employeeService.findById(id);
	}
	
	@GetMapping("/name/{name}")
	public Set<Employee> findEmployeeByName(@PathVariable("name") String name) {
		return this.employeeService.fetchEmployeesByName(name);
	}

	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ADMIN')")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return this.employeeService.save(employee);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@PreAuthorize("hasAuthority('ADMIN')")
	public Employee updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee) {
		Employee e = this.employeeService.findById(id);
		e.setFirstName(employee.getFirstName());	
		e.setLastName(employee.getLastName());
		e.setEmail(employee.getEmail());
		return this.employeeService.save(e);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteEmployeeById(@PathVariable("id") long id) {
		 this.employeeService.deleteById(id);
	}

	@GetMapping("/sort/{order}")
	@ApiResponses({
	@ApiResponse(
			description = "Fetches all the employees sorted by first name",
			responseCode = "200"),
	@ApiResponse(
			description = "You are not authenticated user",
			responseCode = "401"),
	@ApiResponse(
			description = "You are not authorized user",
			responseCode = "403")
	})
	public List<Employee> fetchEmployeesSortedByFirstName(@PathVariable("order") String order){
		return this.employeeService.findByFirstNameSorted(order);
	}
}
