package com.greatlearning.empmanagementsystem.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.empmanagementsystem.dao.UserRepository;
import com.greatlearning.empmanagementsystem.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public Set<User> fetchAll() {
		return new HashSet<>(this.userRepository.findAll());
	}

}
