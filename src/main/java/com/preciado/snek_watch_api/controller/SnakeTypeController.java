package com.preciado.snek_watch_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preciado.snek_watch_api.model.SnakeType;
import com.preciado.snek_watch_api.repository.SnakeTypeRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/snake-types")
public class SnakeTypeController {
    private SnakeTypeRepository snakeTypeRepository;
    public SnakeTypeController(
        SnakeTypeRepository snakeTypeRepository
    ) {
        this.snakeTypeRepository = snakeTypeRepository;
    }
    @PostMapping
    public ResponseEntity<long> postMethodName(@RequestBody SnakeType entity) {
        snakeTypeRepository.create(entity);
        return entity;
    }
    
}
