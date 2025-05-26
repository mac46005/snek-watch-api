package com.preciado.snek_watch_api.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.preciado.snek_watch_api.model.FeedingLog;

public class FeedingLogRepository implements ICRUD<FeedingLog> {
    private final String TABLE_NAME = "feedinglogs";
    private final JdbcTemplate jdbcTemplate;

    public FeedingLogRepository(
        JdbcTemplate jdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long create(FeedingLog data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public List<FeedingLog> read() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public FeedingLog read(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public boolean update(FeedingLog data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(FeedingLog data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
