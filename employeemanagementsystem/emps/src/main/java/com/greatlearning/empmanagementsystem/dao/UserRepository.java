package com.greatlearning.empmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.empmanagementsystem.model.User;

public interface UserRepository extends JpaRepository<User , Long> {
    User findByUsername(String username);
}
