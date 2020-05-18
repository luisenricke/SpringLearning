package com.luisenricke.javaspringclubmysql.controller;

import com.luisenricke.javaspringclubmysql.entity.User;
import com.luisenricke.javaspringclubmysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private UserService service;

    @Autowired
    public HomeController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String users(Model model) {
//        List<User> list = new ArrayList<User>();
//        list.add(new User("Test", "test", "test"));
//        list.add(new User("Test2", "test2", "test2"));
        List<User> list = service.getAll();
        model.addAttribute("users", list);
        return "index";
    }

}
