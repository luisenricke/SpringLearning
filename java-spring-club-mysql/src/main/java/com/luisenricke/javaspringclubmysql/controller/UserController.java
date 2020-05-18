package com.luisenricke.javaspringclubmysql.controller;

import com.luisenricke.javaspringclubmysql.entity.User;
import com.luisenricke.javaspringclubmysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/user")
    List<User> all() {
        return service.getAll();
    }

    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return service.save(newUser);
    }

    // Single item

    @GetMapping("/user/{id}")
    User get(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/user/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
        return service.get(id);
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id) {
        service.deleteById(id);
    }


}
