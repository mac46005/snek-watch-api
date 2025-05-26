package com.preciado.snek_watch_api.model;

import java.time.LocalDateTime;

public class FeedingLog {
    private long id;
    private long snakeId;
    private LocalDateTime fedAt;
    private String foodItem;
    private String notes;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getSnakeId() {
        return snakeId;
    }
    public void setSnakeId(long snakeId) {
        this.snakeId = snakeId;
    }
    public LocalDateTime getFedAt() {
        return fedAt;
    }
    public void setFedAt(LocalDateTime fedAt) {
        this.fedAt = fedAt;
    }
    public String getFoodItem() {
        return foodItem;
    }
    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
