package com.sa.hellodemo.controller;

import com.sa.hellodemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class DemoController {
    @GetMapping("/hello")
    public String hello(Model model) {


        List<User> userList = new ArrayList<>();
        userList.add(new User(1,"Haruki","Murakami@gmail.co"));
        userList.add(new User(2,"Orhan","Pamuk@gmail.co"));
        userList.add(new User(3,"Yaşar","Kemal@gmail.co"));

        model.addAttribute("name", "World");
        model.addAttribute("userList", userList);
        return "hello"; // This will render the hello.html Thymeleaf template
    }
}
