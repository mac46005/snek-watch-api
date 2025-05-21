package com.preciado.snek_watch_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preciado.snek_watch_api.model.SnakeType;
import com.preciado.snek_watch_api.repository.SnakeTypeRepository;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/snake-types")
public class SnakeTypeController {
    private SnakeTypeRepository snakeTypeRepository;

    public SnakeTypeController(
            SnakeTypeRepository snakeTypeRepository) {
        this.snakeTypeRepository = snakeTypeRepository;
    }

    @PostMapping
    public ResponseEntity<Long> postMethodName(@RequestBody SnakeType entity) {
        long newId = snakeTypeRepository.create(entity);
        URI location = URI.create("/snake-types/" + newId);
        return ResponseEntity.created(location).body(newId);
    }


    @GetMapping
    public ResponseEntity<List<SnakeType>> getMethodName() {
        
        return ResponseEntity.ok(snakeTypeRepository.read());
    }
    
}