package com.preciado.snek_watch_api.repository;

import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SnakeTypeRepository {
    private final JdbcTemplate jdbcTemplate;

    public SnakeTypeRepository(
        JdbcTemplate jdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // -- CREATE --
    public void create()
}
