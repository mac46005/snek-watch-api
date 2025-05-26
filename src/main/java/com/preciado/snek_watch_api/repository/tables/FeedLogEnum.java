package com.preciado.snek_watch_api.repository.tables;

public enum FeedLogEnum {
    ID("id"),
    SNAKE_ID("snake_id"),
    FED_AT("fed_at"),
    FOOD_ITEM("food_item"),
    NOTES("notes");
    private String columnName;
    private FeedLogEnum(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public String toString() {
        return columnName;
    }
}
