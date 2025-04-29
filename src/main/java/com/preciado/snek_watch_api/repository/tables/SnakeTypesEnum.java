package com.preciado.snek_watch_api.repository.tables;

public enum SnakeTypesEnum {
    ID("id"),
    COMMON_NAME("common_name"),
    TAXONOMY_NAME("taxonomy_name"),
    CARE_LEVEL("care_level"),
    OVERVIEW("overview"),
    AVERAGE_LIFE_SPAN_IN_YRS("average_life_span_in_yrs"),
    AVERAGE_ADULT_LENGTH_IN_FEET("average_adult_length_in_feet"),
    DIET("diet");

    private String columnName;
    private SnakeTypesEnum(String columnName) {
        this.columnName = columnName;
    }
    
    @Override
    public String toString() {
        return columnName;
    }
}
