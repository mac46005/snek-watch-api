package com.preciado.snek_watch_api.repository.tables;

public enum SnakeEnum {
    ;
    private String columnName;

    private SnakeEnum(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public String toString() {
        return columnName;
    }
}
