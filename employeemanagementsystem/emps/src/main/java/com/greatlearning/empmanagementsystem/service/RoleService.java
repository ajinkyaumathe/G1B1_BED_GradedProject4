package com.greatlearning.empmanagementsystem.service;

import java.util.Set;

import com.greatlearning.empmanagementsystem.model.Role;

public interface RoleService {
	
	Role save(Role role);
	Set<Role> fetchAll();
	
}
