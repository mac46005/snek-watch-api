package com.preciado.snek_watch_api.model;

import java.time.LocalDateTime;

public class FeedingLog {
    private long id;
    private long snakeId;
    private LocalDateTime fedAt;
    private String foodItem;
    private String notes;
}
