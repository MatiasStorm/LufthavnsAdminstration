package com.cph.adminstration.repository.dao;
import com.cph.adminstration.model.PlaneProcessing;
import com.cph.adminstration.repository.mapper.PlaneProcessingMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class PlaneProcessingDAO implements CRUD_DAO<PlaneProcessing, Integer> {

    private final JdbcTemplate template;
    PlaneProcessingMapper planeProcessingMapper;

    public PlaneProcessingDAO(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public PlaneProcessing create(PlaneProcessing planeProcessing) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = " INSERT INTO plane_processing " +
                "(work_id, departure_id, arrival_id, start, end)" +
                " VALUES (?, ?, ?, ?, ?)";



            String start = planeProcessing.getStart()!= null ? planeProcessing.getStart().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) :null ;

            String end = planeProcessing.getEnd()!= null ? planeProcessing.getEnd().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) :null;


        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, planeProcessing.getWorkId());
            ps.setInt(2, planeProcessing.getDepartureId());
            ps.setInt(3, planeProcessing.getArrivalId());
            ps.setString(4,start);
            ps.setString(5,end);
            return ps;
        }, keyHolder);
        planeProcessing.setPlaneProcessingId(keyHolder.getKey().intValue());
        return planeProcessing;
}
    @Override
    public List<PlaneProcessing> readAll() {
    String sql= "SELECT * FROM plane_processing";
        return template.query(sql, planeProcessingMapper);
    }

    @Override
    public PlaneProcessing getByID(Integer plane_processing_id) {
        String sql = "SELECT * FROM plane_processing WHERE plane_processing_id = ?";
        return template.queryForObject(sql, planeProcessingMapper, plane_processing_id);
    }

    @Override
    public void update(PlaneProcessing planeProcessing) {

    }

    @Override
    public void delete(Integer id) {

    }
}
