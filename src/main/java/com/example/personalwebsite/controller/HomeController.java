package com.example.personalwebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomeController is responsible for handling HTTP GET requests for various endpoints
 * and returning the corresponding view names to be rendered.
 */
@Controller
public class HomeController {

    /**
     * Handles GET requests to the root URL ("/") and returns the "index" view.
     *
     * @return the name of the view to be rendered (index.html)
     */
    @GetMapping("/")
    public String home() {
        return "index";
    }

    /**
     * Handles GET requests to the "/todos/home" URL and returns the "todo" view.
     *
     * @return the name of the view to be rendered (todo.html)
     */
    @GetMapping("/todos/home")
    public String todos() {
        return "todo";
    }

    /**
     * Handles GET requests to the "/music" URL and returns the "music" view.
     *
     * @return the name of the view to be rendered (music.html)
     */
    @GetMapping("/music")
    public String music() {
        return "music";
    }

    /**
     * Handles GET requests to the "/hobbies" URL and returns the "hobbies" view.
     *
     * @return the name of the view to be rendered (hobbies.html)
     */
    @GetMapping("/hobbies")
    public String hobbies() {
        return "hobbies";
    }
}
