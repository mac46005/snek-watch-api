package com.preciado.snek_watch_api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/snakes")
public class SnakeController {
    
    @GetMapping
    public String getMethodName(
        
    ) {
        return "Hello world!!!";
    }
    
}
