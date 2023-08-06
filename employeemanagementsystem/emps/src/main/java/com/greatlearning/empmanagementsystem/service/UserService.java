package com.greatlearning.empmanagementsystem.service;

import java.util.Set;

import com.greatlearning.empmanagementsystem.model.User;

public interface UserService {
	
	User save(User user);
	Set<User> fetchAll();
	
}
