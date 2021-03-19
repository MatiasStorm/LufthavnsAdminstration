package com.cph.adminstration.repository.dao;

import com.cph.adminstration.model.TravelProcessType;
import com.cph.adminstration.repository.mapper.TravelProcessTypeMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TravelProcessTypeDAO implements CRUD_DAO<TravelProcessType, Integer>{
    private String tableName = "travel_processtype";
    private JdbcTemplate template;
    private TravelProcessTypeMapper mapper;

    public TravelProcessTypeDAO(JdbcTemplate template){
        this.template = template;
        this.mapper = new TravelProcessTypeMapper();
    }

    @Override
    public TravelProcessType create(TravelProcessType travelProcessType) {
        return null;
    }

    @Override
    public List<TravelProcessType> readAll() {
        String sql = "SELECT * FROM " + tableName;
        return template.query(sql, mapper);
    }

    @Override
    public TravelProcessType getByID(Integer primaryKey) {
        String sql = "SELECT * FROM " + tableName + " WHERE travel_processtype_id = ?";
        return template.queryForObject(sql, mapper, primaryKey);
    }

    @Override
    public void update(TravelProcessType travelProcessType) {

    }

    @Override
    public void delete(Integer primaryKey) {

    }
}
