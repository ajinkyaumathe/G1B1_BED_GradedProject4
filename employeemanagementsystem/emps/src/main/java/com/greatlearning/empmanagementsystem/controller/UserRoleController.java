package com.greatlearning.empmanagementsystem.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.empmanagementsystem.model.Employee;
import com.greatlearning.empmanagementsystem.model.Role;
import com.greatlearning.empmanagementsystem.service.RoleService;
import com.greatlearning.empmanagementsystem.model.User;
import com.greatlearning.empmanagementsystem.service.UserService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@EnableMethodSecurity
@RestController
@RequestMapping("/api/users_roles")
public class UserRoleController {

    @Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;

    @PostMapping("/role")
	@ResponseStatus(code = HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ADMIN')")
	public Role saveRole(@RequestBody Role role) {
		return this.roleService.save(role);
	}

    @GetMapping("/roles")
	@ApiResponses({
	@ApiResponse(
			description = "Fetches all the roles",
			responseCode = "200"),
    })
	public Set<Role> fetchRoles(){
		return this.roleService.fetchAll();
	}

	@PostMapping("/user")
	@ResponseStatus(code = HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ADMIN')")
	public User saveUser(@RequestBody User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return this.userService.save(user);
	}

    @GetMapping("/users")
	@ApiResponses({
	@ApiResponse(
			description = "Fetches all the users",
			responseCode = "200"),
    })
	public Set<User> fetchUsers(){
		return this.userService.fetchAll();
	}

}

