package com.preciado.snek_watch_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.preciado.snek_watch_api.model.SnakeType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/snakes")
public class SnakeController {
    @GetMapping
    public String getMethodName(
        
    ) {
        return "Hello world!!!";
    }
    
    @PostMapping
    public SnakeType postMethodName(@RequestBody SnakeType entity) {
        //TODO: process POST request
        
        return entity;
    }
    
}
