package dev.chha.incidenttracker.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello all";
    }

    @GetMapping("/user")
    public String user() {
        return "Hello User";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hello Admin";
    }
}
