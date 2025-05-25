package com.preciado.snek_watch_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.preciado.snek_watch_api.model.Snake;
import com.preciado.snek_watch_api.model.SnakeType;
import com.preciado.snek_watch_api.repository.SnakeRepository;

import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


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
    public ResponseEntity<Snake> getSnakeByIdEndpoint(@PathVariable long id) {
        return ResponseEntity.ok().body(snakeRepository.read(id));
    }
    

    @PostMapping
    public ResponseEntity<Snake> createSnakeEndpoint(@RequestBody Snake entity) {
        long id = snakeRepository.create(entity);
        entity.setId(id);
        URI location = URI.create("/api/snakes/" + id);

        return ResponseEntity.created(location).body(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Snake> updateSnakeByIdEndpoint(@PathVariable long id, @RequestBody Snake entity) {
        entity.setId(id);
        snakeRepository.update(entity);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSnakeEndpoint(
        @PathVariable long id
    ) {
        Snake s = new Snake();
        s.setId(id);
        boolean deleted = snakeRepository.delete(s);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Snake wit the given ID does not exist");
        }
    }

}
