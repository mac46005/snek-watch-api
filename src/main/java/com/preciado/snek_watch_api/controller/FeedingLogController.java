package com.preciado.snek_watch_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preciado.snek_watch_api.model.FeedingLog;
import com.preciado.snek_watch_api.repository.FeedingLogRepository;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/feeding-logs")
public class FeedingLogController {
    FeedingLogRepository feedingLogRepository;

    public FeedingLogController(
        FeedingLogRepository feedingLogRepository
    ) {
        this.feedingLogRepository = feedingLogRepository;
    }

    @GetMapping
    public ResponseEntity<List<FeedingLog>> getAllFeedingLogsEndpoint() {
        return ResponseEntity.ok().body(feedingLogRepository.read());
    }


    
}
