package com.preciado.snek_watch_api.repository.tables;

public enum SnakeEnum {
    ID("id"),
    NAME("name"),
    DOB("dob"),
    SNAKE_TYPE_ID("snake_type_id");
    private String columnName;

    private SnakeEnum(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public String toString() {
        return columnName;
    }
}
