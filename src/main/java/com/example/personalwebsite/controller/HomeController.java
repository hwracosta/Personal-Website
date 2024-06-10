package com.example.personalwebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/todos/home")
    public String todos() {
        return "todo";
    }

    @GetMapping("/music")
    public String music() {
        return "music";
    }

    @GetMapping("/hobbies")
    public String hobbies() {
        return "hobbies";
    }
}