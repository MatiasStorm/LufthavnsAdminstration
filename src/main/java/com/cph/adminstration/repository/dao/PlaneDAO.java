package com.cph.adminstration.repository.dao;

import com.cph.adminstration.model.Plane;
import com.cph.adminstration.repository.mapper.PlaneMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaneDAO implements CRUD_DAO<Plane, Integer> {

    private final JdbcTemplate template;
    private final PlaneMapper planeMapper = new PlaneMapper();

    public PlaneDAO(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Plane create(Plane plane) {

        String sql = "INSERT INTO plane" +
                "(iata, type, size)" + "VALUES (?,?,?)";

        template.update(sql, plane.getIata(), plane.getType(), Character.toString(plane.getPlaneSize()));
        return plane;
    }

    @Override
    public List<Plane> readAll() {
        String sql = "SELECT * FROM plane";
        return template.query(sql, planeMapper);
    }

    @Override
    public Plane getByID(Integer iata)
    {
        String sql = "SELECT * FROM plane WHERE iata = ?";
        return template.queryForObject(sql, planeMapper, iata);
    }

    @Override
    public void update(Plane plane) {

    }

    @Override
    public void delete(Integer primaryKey) {

    }
}
