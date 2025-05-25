package com.preciado.snek_watch_api.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.preciado.snek_watch_api.model.Snake;
import com.preciado.snek_watch_api.repository.tables.SnakeEnum;
import com.preciado.snek_watch_api.service.SqlStatementCreator;

@Repository
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

        return ((Number) keyHolder.getKeyList().get(0).get("id")).longValue();

    }

    @Override
    public List<Snake> read() {
        String selectStatement = SqlStatementCreator.createSelectStatement(
            TABLE_NAME, 
            "",
            SnakeEnum.NAME.toString(),
            SnakeEnum.DOB.toString(),
            SnakeEnum.SNAKE_TYPE_ID.toString()
        );

        return jdbcTemplate.query
        (selectStatement, (rs, rowNum) -> {
                Snake snake = new Snake();
                snake.setName(rs.getString(SnakeEnum.NAME.toString()));
                snake.setDob(rs.getDate(SnakeEnum.DOB.toString()).toLocalDate());
                snake.setSnakeTypeId(rs.getLong(SnakeEnum.SNAKE_TYPE_ID.toString()));
                return snake;
            }
        );
    }

    @Override
    public Snake read(long id) {
        String selectStatement = SqlStatementCreator.createSelectStatement(TABLE_NAME, "WHERE id = " + id, SnakeEnum.ID.toString(),SnakeEnum.NAME.toString(), SnakeEnum.DOB.toString(), SnakeEnum.SNAKE_TYPE_ID.toString());

        return jdbcTemplate.query(
            selectStatement, 
            (rs, rowNum) -> {
                Snake snake = new Snake();
                snake.setId(id);
                snake.setName(rs.getString(SnakeEnum.NAME.toString()));
                snake.setDob(rs.getDate(SnakeEnum.DOB.toString()).toLocalDate());
                snake.setSnakeTypeId(rs.getLong(SnakeEnum.SNAKE_TYPE_ID.toString()));
                return snake;
            }
        ).get(0);
    }

    @Override
    public boolean update(Snake data) {
        String updateStatement = SqlStatementCreator.createUpdateStatement(TABLE_NAME, "WHERE id = ?", SnakeEnum.NAME.toString(), SnakeEnum.DOB.toString(),SnakeEnum.SNAKE_TYPE_ID.toString());

        return jdbcTemplate.update(
            updateStatement,
            data.getName(),
            data.getDob(),
            data.getSnakeTypeId(),
            data.getId()
        ) > 0;
    }

    @Override
    public boolean delete(Snake data) {
        String deleteStatement = SqlStatementCreator.createDeleteStatement(TABLE_NAME, "WHERE id = ?");
        return jdbcTemplate.update(deleteStatement, data.getId()) > 0;
    }

}
