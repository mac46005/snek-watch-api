package com.preciado.snek_watch_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preciado.snek_watch_api.repository.FeedingLogRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/snakes")
public class FeedingLogController {
    FeedingLogRepository feedingLogRepository;

    public FeedingLogController(
        FeedingLogRepository feedingLogRepository
    ) {
        this.feedingLogRepository = feedingLogRepository;
    }

    @GetMapping
    public String getMethodName() {
        return new String();
    }
    
}
