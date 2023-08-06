package com.greatlearning.empmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.greatlearning.empmanagementsystem.model.Role;

public interface RoleRepository extends JpaRepository<Role , Long> {
}
