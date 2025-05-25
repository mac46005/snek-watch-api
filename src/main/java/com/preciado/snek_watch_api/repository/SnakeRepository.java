package com.preciado.snek_watch_api.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.preciado.snek_watch_api.model.Snake;
import com.preciado.snek_watch_api.repository.tables.SnakeEnum;
import com.preciado.snek_watch_api.service.SqlStatementCreator;

public class SnakeRepository implements ICRUD<Snake> {
    private final String TABLE_NAME = "snakes";
    private final JdbcTemplate jdbcTemplate;

    public SnakeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long create(Snake data) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
    

        String insertStatement = SqlStatementCreator.createInsertStatement(
            TABLE_NAME,
            SnakeEnum.NAME.toString(),
            SnakeEnum.DOB.toString(),
            SnakeEnum.SNAKE_TYPE_ID.toString()
        );

        jdbcTemplate.update(
            connection -> {
                PreparedStatement ps = connection.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1, data.getName());

                ps.setDate(2, java.sql.Date.valueOf(data.getDob()));

                ps.setLong(3, data.getSnakeTypeId());

                return ps;
            },
            keyHolder
        );

        return ((Number) keyHolder.getKeyList().get(0).get("id")).longValue()

    }

    @Override
    public List<Snake> read() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public Snake read(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public boolean update(Snake data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Snake data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
