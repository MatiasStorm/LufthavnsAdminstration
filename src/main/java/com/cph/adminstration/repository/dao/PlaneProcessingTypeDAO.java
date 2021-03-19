package com.cph.adminstration.repository.dao;

import com.cph.adminstration.model.PlaneProcessType;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PlaneProcessingTypeDAO implements CRUD_DAO<PlaneProcessType, Integer> {

    private final JdbcTemplate template;

    public PlaneProcessingTypeDAO(JdbcTemplate template) {
        this.template = template;
    }


    @Override
    public PlaneProcessType create(PlaneProcessType planeProcess) {
        return null;
    }

    @Override
    public List<PlaneProcessType> readAll() {
        return null;
    }

    @Override
    public PlaneProcessType getByID(Integer primaryKey) {
        return null;
    }

    @Override
    public void update(PlaneProcessType planeProcess) {

    }

    @Override
    public void delete(Integer primaryKey) {

    }
}
