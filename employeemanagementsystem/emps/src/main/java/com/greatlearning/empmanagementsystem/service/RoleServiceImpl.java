package com.greatlearning.empmanagementsystem.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.empmanagementsystem.dao.RoleRepository;
import com.greatlearning.empmanagementsystem.model.Role;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	
	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Set<Role> fetchAll() {
		return new HashSet<>(this.roleRepository.findAll());
	}

}
