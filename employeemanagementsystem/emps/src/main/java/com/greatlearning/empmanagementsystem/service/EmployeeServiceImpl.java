package com.greatlearning.empmanagementsystem.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greatlearning.empmanagementsystem.dao.EmployeeRepository;
import com.greatlearning.empmanagementsystem.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public Employee save(Employee employee) {
		return empRepository.save(employee);
	}

	@Override
	public Set<Employee> fetchAll() {
		//return Set.copyOf(this.empRepository.findAll());
		return new HashSet<>(this.empRepository.findAll());
	}

	@Override
	public Employee findById(long id) {
		return this.empRepository.findById(id).orElseThrow();
	}

	@Override
	public void deleteById(long id) {
		this.empRepository.deleteById(id);
	}

	@Override
	public Set<Employee> fetchEmployeesByName(String name) {
		return this.empRepository.findByFirstNameLike(name);
	}

	@Override
	public List<Employee> findByFirstNameSorted(String order) {
		if (order.toLowerCase().equals("asc"))
			return this.empRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
		else
			return this.empRepository.findAll(Sort.by(Sort.Direction.DESC, "firstName"));
	}

}
