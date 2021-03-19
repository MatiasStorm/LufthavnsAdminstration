package com.cph.adminstration.repository.dao;

import com.cph.adminstration.model.TravelProcessing;
import com.cph.adminstration.repository.mapper.TravelProcessingMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class TravelProcessingDAO implements CRUD_DAO<TravelProcessing, Integer>{
    private final String tableName = "travel_processing";
    private JdbcTemplate template;
    private TravelProcessingMapper travelProcessingMapper;

    public TravelProcessingDAO(JdbcTemplate template){
        this.template = template;
        this.travelProcessingMapper = new TravelProcessingMapper();
    }

    @Override
    public TravelProcessing create(TravelProcessing travelProcessing) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = String.format("INSERT INTO %s (department_id, travel_processtype_id, from_departure, from_arrival, to_departure, to_arrival) VALUES(?,?,?,?,?,?)", tableName);
        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, travelProcessing.getDepartmentId());
            ps.setInt(2, travelProcessing.getTravelProcessId());
            ps.setInt(3, travelProcessing.getFromDepartureId());
            ps.setInt(4, travelProcessing.getFromArrivalId());
            ps.setInt(5, travelProcessing.getToDepartureId());
            ps.setInt(6, travelProcessing.getToArrivalId());
            return ps;
        }, keyHolder);

        travelProcessing.setId(keyHolder.getKey().intValue());
        return travelProcessing;
    }

    @Override
    public List<TravelProcessing> readAll() {
        String sql = "SELECT * from " + tableName;
        return template.query(sql, travelProcessingMapper);
    }

    @Override
    public TravelProcessing getByID(Integer primaryKey) {
        String sql = "SELECT * from " + tableName + " WHERE travel_processing_id = ?";
        return template.queryForObject(sql, travelProcessingMapper, primaryKey);
    }

    @Override
    public void update(TravelProcessing travelProcessing) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "UPDATE " + tableName
                    + " SET department_id=?, travel_processtype_id=?, from_departure=?, from_arrival=?, to_departure=?, to_arrival=?"
                    + " WHERE travel_processing_id=?";
        template.update(
                sql,
                travelProcessing.getDepartmentId(),
                travelProcessing.getTravelProcessId(),
                travelProcessing.getFromDepartureId(),
                travelProcessing.getFromArrivalId(),
                travelProcessing.getToDepartureId(),
                travelProcessing.getToArrivalId(),
                travelProcessing.getId()
        );
    }

    @Override
    public void delete(Integer primaryKey) {
        String sql = "DELETE FROM " + tableName + " WHERE travel_processing_id = ?";
        template.update(sql, primaryKey);
    }
}
