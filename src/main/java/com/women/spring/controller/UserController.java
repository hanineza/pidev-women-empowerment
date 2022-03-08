package com.women.spring.controller;

import com.women.spring.model.User;
import com.women.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") int id) {
        return userService.findById(id);
    }


    @PutMapping("/virer/{id}")
    public User virerLearner(@PathVariable("id") int id ) {
        return userService.virer(id);
    }
    @PutMapping("/sactionner/{id}")
    public User sactionnerLearner (@PathVariable("id")int id ) {
        return userService.sactionner(id);
    }
    @PutMapping("/avertir/{id}")
    public User avertirLearner (@PathVariable("id") int id ) {
        return userService.avertire(id);
    }
}
