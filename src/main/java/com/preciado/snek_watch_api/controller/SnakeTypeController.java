package com.preciado.snek_watch_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preciado.snek_watch_api.model.SnakeType;
import com.preciado.snek_watch_api.repository.SnakeTypeRepository;

import java.net.URI;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/snake-types")
public class SnakeTypeController {
    private SnakeTypeRepository snakeTypeRepository;

    public SnakeTypeController(
            SnakeTypeRepository snakeTypeRepository
    ) {
        this.snakeTypeRepository = snakeTypeRepository;
    }

    @PostMapping
    public ResponseEntity<Long> createSnakeTypeEndpoint(@RequestBody SnakeType entity) {
        long newId = snakeTypeRepository.create(entity);
        URI location = URI.create("/snake-types/" + newId);
        return ResponseEntity.created(location).body(newId);
    }


    @GetMapping
    public ResponseEntity<List<SnakeType>> getSnakeTypeEndpoint() {
        return ResponseEntity.ok(snakeTypeRepository.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SnakeType> getSnakeTypeByIdEndpoint(@PathVariable long id) {
        return ResponseEntity.ok(snakeTypeRepository.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSnakeTypeEndpoint(@PathVariable Long id, @RequestBody SnakeType entity) {
        entity.setId(id);
        try {
            snakeTypeRepository.update(entity);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSnakeTypeEndpoint(
        @PathVariable Long id
    ) {
        try {
            SnakeType st = new SnakeType();
            st.setId(id);
            snakeTypeRepository.delete(st);
            return ResponseEntity.noContent().build();
        } catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        
    }


    @GetMapping("/selection")
    public ResponseEntity<List<SnakeType>> getSelection() {
        return ResponseEntity.ok().body(snakeTypeRepository.getSelection());
    }
    
}