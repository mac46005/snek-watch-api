package com.preciado.snek_watch_api.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.preciado.snek_watch_api.model.SnakeType;
import com.preciado.snek_watch_api.repository.tables.SnakeTypesEnum;
import com.preciado.snek_watch_api.service.SqlStatementCreator;

@Repository
public class SnakeTypeRepository implements ICRUD<SnakeType> {
    private final String TABLE_NAME = "snake_types";

    private final JdbcTemplate jdbcTemplate;

    public SnakeTypeRepository(
            JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long create(SnakeType data) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = SqlStatementCreator.createInsertStatement(
                TABLE_NAME,
                SnakeTypesEnum.COMMON_NAME.toString(),
                SnakeTypesEnum.TAXONOMY_NAME.toString(),
                SnakeTypesEnum.CARE_LEVEL.toString(),
                SnakeTypesEnum.OVERVIEW.toString(),
                SnakeTypesEnum.AVERAGE_LIFE_SPAN_IN_YRS.toString(),
                SnakeTypesEnum.AVERAGE_ADULT_LENGTH_IN_FEET.toString(),
                SnakeTypesEnum.DIET.toString());

        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement(
                            sql,
                            Statement.RETURN_GENERATED_KEYS);

                    ps.setString(1, data.getCommonName());

                    ps.setString(2, data.getTaxonomyName());

                    ps.setString(3, data.getCareLevel());

                    ps.setString(4, data.getOverview());

                    ps.setInt(5, data.getAverageLifeSpanInYrs());

                    ps.setDouble(6, data.getAverageAdultLengthInFeet());

                    ps.setString(7, data.getDiet());

                    return ps;
                },
                keyHolder);
        return ((Number) keyHolder.getKeyList().get(0).get("id")).longValue();
    }

    @Override
    public List<SnakeType> read() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public SnakeType read(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public boolean update(SnakeType data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(SnakeType data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
