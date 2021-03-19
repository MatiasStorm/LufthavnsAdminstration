package com.cph.adminstration.repository.dao;

import com.cph.adminstration.model.PlaneProcessingType;
import com.cph.adminstration.repository.mapper.PlaneProcessingTypeMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;

public class PlaneProcessingTypeDAO implements CRUD_DAO<PlaneProcessingType, Integer> {

    private final JdbcTemplate template;
    PlaneProcessingTypeMapper planeProcessingTypeMapper;

    public PlaneProcessingTypeDAO(JdbcTemplate template) {
        this.template = template;
    }


    @Override
    public PlaneProcessingType create(PlaneProcessingType planeProcess) {
        return null;
    }

    @Override
    public List<PlaneProcessingType> readAll() {
        String sql = "SELECT * FROM plane_processtype";
        return template.query(sql, planeProcessingTypeMapper);
    }

    @Override
    public PlaneProcessingType getByID(Integer work_id) {
    String sql = "SELECT * FROM plane_processtype WHERE work_id = ?";
        return template.queryForObject(sql, planeProcessingTypeMapper, work_id);
    }

    @Override
    public void update(PlaneProcessingType planeProcess) {

    }

    @Override
    public void delete(Integer primaryKey) {

    }
}
