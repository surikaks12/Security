package com.company.controller;

import com.company.domain.MyUser;
import com.company.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    private final MyUserDetailsService userDetailsService;

    @Autowired
    public UserController(MyUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping(value = "")
    public List<MyUser> getUserByUsername() {
        return Arrays.asList(
                new MyUser(1, "Usera", "user1@abc.com"),
                new MyUser(2, "Userb", "user2@abc.com"),
                new MyUser(3, "Userc", "user3@abc.com"));
    }
}