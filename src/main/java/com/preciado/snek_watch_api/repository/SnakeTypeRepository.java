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

@Repository
public class SnakeTypeRepository implements ICRUD<SnakeType> {
    private final JdbcTemplate jdbcTemplate;

    public SnakeTypeRepository(
        JdbcTemplate jdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long create(SnakeType data) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = """
            INSERT INTO snake_types (common_name, taxonomy_name, care_level, overview, average_life_span_in_yrs, average_adult_length_in_feet, diet) VALUES (?, ?, ?, ?, ?, ?, ?);
        """;

        jdbcTemplate.update(
            connection -> {
                PreparedStatement ps = connection.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
                );

                ps.setString(1, data.getCommonName());
                ps.setString(2, data.getTaxonomyName());
                ps.setString(3, data.getCareLevel());
                ps.setString(4, data.getOverview());
                ps.setInt(5, data.getAverageLifeSpanInYrs());
                ps.setFloat(0, 0);
                
                return ps;
            },
            keyHolder
        );
        return keyHolder.getKey().longValue();
    }

    @Override
    public List<SnakeType> read() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public SnakeType read(long id) {
        String sql = """
            SELECT  id, common_name, taxonomy_name, care_level, overview, average_life_span_in_yrs, average_adult_length_in_feet, diet FROM snake_types;
        """;
        jdbcTemplate.query(
            sql, 
            rs -> {
                rs.getString("common_name");
            }
        );
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
