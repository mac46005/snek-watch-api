package com.preciado.snek_watch_api.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.preciado.snek_watch_api.model.FeedingLog;
import com.preciado.snek_watch_api.repository.tables.FeedLogEnum;
import com.preciado.snek_watch_api.service.SqlStatementCreator;

@Repository
public class FeedingLogRepository implements ICRUD<FeedingLog> {

    
    private final String TABLE_NAME = "feeding_logs";

    private final JdbcTemplate jdbcTemplate;

    public FeedingLogRepository(
        JdbcTemplate jdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long create(FeedingLog data) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        String insertStatement = SqlStatementCreator.createInsertStatement(TABLE_NAME, FeedLogEnum.SNAKE_ID.toString(), FeedLogEnum.FED_AT.toString(), FeedLogEnum.FOOD_ITEM.toString(), FeedLogEnum.NOTES.toString());

        return jdbcTemplate.update(
            connection -> {
                PreparedStatement ps = connection.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);
                
                ps.setLong(1, data.getSnakeId());

                ps.setTimestamp(2, java.sql.Timestamp.valueOf(data.getFedAt()));

                ps.setString(3, data.getFoodItem());

                ps.setString(4, data.getNotes());

                return ps;
            }
        );
    }

    @Override
    public List<FeedingLog> read() {
        String selectStatement = SqlStatementCreator.createSelectStatement(TABLE_NAME, "", FeedLogEnum.ID.toString(), FeedLogEnum.SNAKE_ID.toString(),FeedLogEnum.FED_AT.toString(), FeedLogEnum.FOOD_ITEM.toString(), FeedLogEnum.NOTES.toString());

        return jdbcTemplate.query(
            selectStatement, 
            (rs, rowNum) -> {
                FeedingLog feedingLog = new FeedingLog();
                feedingLog.setId(rs.getLong(FeedLogEnum.ID.toString()));
                feedingLog.setSnakeId(rs.getLong(FeedLogEnum.SNAKE_ID.toString()));
                feedingLog.setFedAt(rs.getTimestamp(FeedLogEnum.FED_AT.toString()).toLocalDateTime());
                feedingLog.setFoodItem(rs.getString(FeedLogEnum.FOOD_ITEM.toString()));
                feedingLog.setNotes(rs.getString(FeedLogEnum.NOTES.toString()));
                return feedingLog;
            }
        );
    }

    @Override
    public FeedingLog read(long id) {
        String selectStatement = SqlStatementCreator.createSelectStatement(TABLE_NAME, "WHERE id = " + id, FeedLogEnum.ID.toString(), FeedLogEnum.SNAKE_ID.toString(), FeedLogEnum.FED_AT.toString(), FeedLogEnum.FOOD_ITEM.toString(), FeedLogEnum.NOTES.toString());

        return jdbcTemplate.query(
            selectStatement, 
            (rs, rowNum) -> {
                FeedingLog feedingLog = new FeedingLog();

                feedingLog.setId(rs.getLong(FeedLogEnum.ID.toString()));
                feedingLog.setSnakeId(rs.getLong(FeedLogEnum.SNAKE_ID.toString()));
                feedingLog.setFedAt(rs.getTimestamp(FeedLogEnum.FED_AT.toString()).toLocalDateTime());
                feedingLog.setFoodItem(rs.getString(FeedLogEnum.FOOD_ITEM.toString()));
                feedingLog.setNotes(rs.getString(FeedLogEnum.NOTES.toString()));


                return feedingLog;
            }
        ).get(0);
    }

    @Override
    public boolean update(FeedingLog data) {
        String updateStatement = SqlStatementCreator.createUpdateStatement(TABLE_NAME, "WHERE id = ?", FeedLogEnum.SNAKE_ID.toString(), FeedLogEnum.FED_AT.toString(), FeedLogEnum.FOOD_ITEM.toString(), FeedLogEnum.NOTES.toString());

        return jdbcTemplate.update(updateStatement, data.getSnakeId(), data.getFedAt(), data.getFoodItem(), data.getNotes(), data.getId()) > 0;
    }

    @Override
    public boolean delete(FeedingLog data) {
        String deleteStatement = SqlStatementCreator.createDeleteStatement(TABLE_NAME, "WHERE id = ?");
        return jdbcTemplate.update(
            deleteStatement,
            data.getId()
        ) > 0;
    }
}
