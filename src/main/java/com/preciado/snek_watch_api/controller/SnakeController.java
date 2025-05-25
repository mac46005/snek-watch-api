package com.preciado.snek_watch_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.preciado.snek_watch_api.model.Snake;
import com.preciado.snek_watch_api.model.SnakeType;
import com.preciado.snek_watch_api.repository.SnakeRepository;

import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/snakes")
public class SnakeController {
    SnakeRepository snakeRepository;

    public SnakeController(
            SnakeRepository snakeRepository) {
        this.snakeRepository = snakeRepository;
    }

    @GetMapping
    public ResponseEntity<List<Snake>> getAllSnakesEndpoint() {
        return ResponseEntity.ok().body(snakeRepository.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Snake> getSnakeById(@PathVariable Long id) {
        return ResponseEntity.ok().body(snakeRepository.read(id));
    }
    

    @PostMapping
    public ResponseEntity<Snake> createSnakeEndpoint(@RequestBody Snake entity) {
        long id = snakeRepository.create(entity);
        entity.setId(id);
        URI location = URI.create("/api/snakes/" + id);

        return ResponseEntity.created(location).body(entity);
    }

}
