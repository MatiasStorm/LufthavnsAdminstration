package com.cph.adminstration.repository.dao;
import com.cph.adminstration.model.PlaneProcess;
import com.cph.adminstration.repository.mapper.PlaneProcessMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class PlaneProcessDAO implements CRUD_DAO<PlaneProcess, Integer> {

    private final JdbcTemplate template;
    PlaneProcessMapper planeProcessMapper;

    public PlaneProcessDAO(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public PlaneProcess create(PlaneProcess planeProcess) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = " INSERT INTO plane_processing " +
                "(work_id, departure_id, arrival_id, start, end, plane_processing_id)" +
                " VALUES (?, ?, ?, ?, ?, ?)";

        String start = planeProcess.getStart().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String end = planeProcess.getFinish().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        template.update(sql, planeProcess.getId(), planeProcess.getDepartureId(), planeProcess.getArrivalId(), start,  end, planeProcess.getPlaneProcessingId() );
        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, planeProcess.getId());
            ps.setInt(2, planeProcess.getDepartureId());
            ps.setInt(3, planeProcess.getArrivalId());
            ps.setString(4,start);
            ps.setString(5,end);
            ps.setInt(6, planeProcess.getPlaneProcessingId());
            return ps;
        }, keyHolder);
        planeProcess.setId((Integer) keyHolder.getKey());
        return planeProcess;
}
    @Override
    public List<PlaneProcess> readAll() {
    String sql= "SELECT * FROM plane_processing";
        return template.query(sql, planeProcessMapper);
    }

    @Override
    public PlaneProcess getByID(Integer id) {
        return null;
    }

    @Override
    public void update(PlaneProcess planeProcess) {

    }

    @Override
    public void delete(Integer id) {

    }
}
