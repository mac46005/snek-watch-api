package com.preciado.snek_watch_api.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.preciado.snek_watch_api.model.SnakeType;
import com.preciado.snek_watch_api.repository.tables.SnakeTypesEnum;
import com.preciado.snek_watch_api.service.SqlStatementCreator;
import com.preciado.snek_watch_api.service.SqlStatementCreator.Set;

@Repository
public class SnakeTypeRepository implements ICRUD<SnakeType> {
    private final String TABLE_NAME = "snake_types";

    private final JdbcTemplate jdbcTemplate;

    private final Logger logger = LoggerFactory.getLogger(SnakeTypeRepository.class);

    public SnakeTypeRepository(
            JdbcTemplate jdbcTemplate
    ) {
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
                SnakeTypesEnum.DIET.toString(),
                SnakeTypesEnum.IMAGE.toString());

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

                    ps.setString(8, data.getImage());

                    return ps;
                },
                keyHolder);
        return ((Number) keyHolder.getKeyList().get(0).get("id")).longValue();
    }

    @Override
    public List<SnakeType> read() {
        String selectStatement = SqlStatementCreator.createSelectStatement(
            TABLE_NAME, 
            "",
             SnakeTypesEnum.ID.toString(),
             SnakeTypesEnum.COMMON_NAME.toString(),
             SnakeTypesEnum.TAXONOMY_NAME.toString(),
             SnakeTypesEnum.CARE_LEVEL.toString(),
             SnakeTypesEnum.OVERVIEW.toString(),
             SnakeTypesEnum.AVERAGE_LIFE_SPAN_IN_YRS.toString(),
             SnakeTypesEnum.AVERAGE_ADULT_LENGTH_IN_FEET.toString(),
             SnakeTypesEnum.DIET.toString(),
             SnakeTypesEnum.IMAGE.toString()
        );

        return jdbcTemplate.query(
            selectStatement,
            (rs, rowNum) -> {
                SnakeType snakeType = new SnakeType();
                logger.info("SnakeTypeRepository.read test");
                snakeType.setId(rs.getLong(SnakeTypesEnum.ID.toString()));
                snakeType.setCommonName(rs.getString(SnakeTypesEnum.COMMON_NAME.toString()));
                snakeType.setTaxonomyName(rs.getString(SnakeTypesEnum.TAXONOMY_NAME.toString()));
                snakeType.setCareLevel(rs.getString(SnakeTypesEnum.CARE_LEVEL.toString()));
                snakeType.setOverview(rs.getString(SnakeTypesEnum.OVERVIEW.toString()));
                snakeType.setAverageLifeSpanInYrs(rs.getInt(SnakeTypesEnum.AVERAGE_LIFE_SPAN_IN_YRS.toString()));
                snakeType.setAverageAdultLengthInFeet(rs.getDouble(SnakeTypesEnum.AVERAGE_ADULT_LENGTH_IN_FEET.toString()));
                snakeType.setDiet(rs.getString(SnakeTypesEnum.DIET.toString()));
                snakeType.setImage(rs.getString(SnakeTypesEnum.IMAGE.toString()));
                return snakeType;
            }
        );
    }

    @Override
    public SnakeType read(long id) {
        String selectStatement = SqlStatementCreator.createSelectStatement(
            TABLE_NAME, 
            "WHERE id = " + id,
             SnakeTypesEnum.ID.toString(),
             SnakeTypesEnum.COMMON_NAME.toString(),
             SnakeTypesEnum.TAXONOMY_NAME.toString(),
             SnakeTypesEnum.CARE_LEVEL.toString(),
             SnakeTypesEnum.OVERVIEW.toString(),
             SnakeTypesEnum.AVERAGE_LIFE_SPAN_IN_YRS.toString(),
             SnakeTypesEnum.AVERAGE_ADULT_LENGTH_IN_FEET.toString(),
             SnakeTypesEnum.DIET.toString(),
             SnakeTypesEnum.IMAGE.toString()
        );

        List<SnakeType> snakeTypes = jdbcTemplate.query(
            selectStatement, 
            (rs, rowNum) -> {
                SnakeType snakeType = new SnakeType();
                snakeType.setId(rs.getLong(SnakeTypesEnum.ID.toString()));
                snakeType.setCommonName(rs.getString(SnakeTypesEnum.COMMON_NAME.toString()));
                snakeType.setTaxonomyName(rs.getString(SnakeTypesEnum.TAXONOMY_NAME.toString()));
                snakeType.setCareLevel(rs.getString(SnakeTypesEnum.CARE_LEVEL.toString()));
                snakeType.setOverview(rs.getString(SnakeTypesEnum.OVERVIEW.toString()));
                snakeType.setAverageLifeSpanInYrs(rs.getInt(SnakeTypesEnum.AVERAGE_LIFE_SPAN_IN_YRS.toString()));
                snakeType.setAverageAdultLengthInFeet(rs.getInt(SnakeTypesEnum.AVERAGE_ADULT_LENGTH_IN_FEET.toString()));
                snakeType.setDiet(rs.getString(SnakeTypesEnum.DIET.toString()));
                snakeType.setImage(rs.getString(SnakeTypesEnum.IMAGE.toString()));
                return snakeType;
            }
        );

        return snakeTypes.get(0);
    }

    // TODO Update statement creator to '?'
    @Override
    public boolean update(SnakeType data) {
        String updateStatement = SqlStatementCreator
        .createUpdateStatement(
            TABLE_NAME, 
            "WHERE id = ?",
            SnakeTypesEnum.COMMON_NAME.toString(),
            SnakeTypesEnum.TAXONOMY_NAME.toString(),
            SnakeTypesEnum.CARE_LEVEL.toString(),
            SnakeTypesEnum.OVERVIEW.toString(),
            SnakeTypesEnum.AVERAGE_LIFE_SPAN_IN_YRS.toString(),
            SnakeTypesEnum.AVERAGE_ADULT_LENGTH_IN_FEET.toString(),
            SnakeTypesEnum.DIET.toString(),
            SnakeTypesEnum.IMAGE.toString()
        );
        return jdbcTemplate.update(
            updateStatement,
            data.getCommonName(),
            data.getTaxonomyName(),
            data.getCareLevel(),
            data.getOverview(),
            data.getAverageLifeSpanInYrs(),
            data.getAverageAdultLengthInFeet(),
            data.getDiet(),
            data.getImage(),
            data.getId()
        ) > 0;
    }

    @Override
    public boolean delete(SnakeType data) {
        String deleteStatement = SqlStatementCreator.createDeleteStatement(TABLE_NAME, "WHERE id = ?");
        return jdbcTemplate.update(deleteStatement, data.getId()) > 0;
    }

    public List<SnakeType> getSelection() {
        String selectStatement = SqlStatementCreator.createSelectStatement(
            TABLE_NAME,"", 
            SnakeTypesEnum.ID.toString(), 
            SnakeTypesEnum.COMMON_NAME.toString(),
            SnakeTypesEnum.IMAGE.toString()
        );
        return jdbcTemplate.query(
            selectStatement, 
            (rs, rowNum) -> {
                SnakeType snakeType = new SnakeType();
                snakeType.setId(rs.getLong(SnakeTypesEnum.ID.toString()));
                snakeType.setImage(rs.getString(SnakeTypesEnum.IMAGE.toString()));
                return snakeType;
            }
        );
    }

}
