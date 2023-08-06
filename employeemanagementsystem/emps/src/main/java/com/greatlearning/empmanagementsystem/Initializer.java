package com.greatlearning.empmanagementsystem;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.greatlearning.empmanagementsystem.model.Role;
import com.greatlearning.empmanagementsystem.dao.RoleRepository;
import com.greatlearning.empmanagementsystem.dao.UserRepository;
import com.greatlearning.empmanagementsystem.model.User;



@Component
public class Initializer {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RoleRepository roleRepo;
    

    

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
           // return args -> {
                Role r = new Role();
                r.setName("ADMIN");
                roleRepo.save(r);
                Set<Role> roles = Set.of(r);
                User u = new User((long) 1,"user","$2a$10$p9E7GBiEeSbFhQYVGuIlrOYqX3fjrquHYNU0Z3b.bmH.FD9Nu19ha",roles,true);
                userRepo.save(u);
            //};
        }
}