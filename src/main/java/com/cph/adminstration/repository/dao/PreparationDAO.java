package com.cph.adminstration.repository.dao;
import com.cph.adminstration.model.Preparation;
import com.cph.adminstration.repository.mapper.PreparationMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class PreparationDAO implements CRUD_DAO<Preparation, Integer> {

    private final JdbcTemplate template;
    PreparationMapper preparationMapper ;

    public PreparationDAO(JdbcTemplate template) {
        this.template = template;
    }



    @Override
    public Preparation create(Preparation preparation) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = " INSERT INTO plane_processing " +
                "(work_id, departure_id, arrival_id_ start, end, plane_processing_id)" +
                " VALUES (?, ?, ?, ?, ?, ?)";

        String start = preparation.getStart().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String end = preparation.getFinish().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        template.update(sql,preparation.getId(), preparation.getDepartureID(), preparation.getArrival_id(), start,  end, preparation.getPlaneProcessingId() );
        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, preparation.getId());
            ps.setInt(2,preparation.getDepartureID());
            ps.setInt(3, preparation.getArrival_id());
            ps.setString(4,start);
            ps.setString(5,end);
            ps.setInt(6,preparation.getPlaneProcessingId());

            return ps;
        }, keyHolder);
            preparation.setId((Integer) keyHolder.getKey());
            return preparation;
}
    @Override
    public List<Preparation> readAll() {
    String sql= "SELECT * FROM plane_processing";
        return template.query(sql, preparationMapper);
    }

    @Override
    public Preparation getByID(Integer id) {
        return null;
    }

    @Override
    public void update(Preparation preparation) {

    }

    @Override
    public void delete(Integer id) {

    }
}
