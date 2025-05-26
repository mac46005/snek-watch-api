package com.preciado.snek_watch_api.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
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
