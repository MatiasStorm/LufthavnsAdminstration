package com.cph.adminstration.repository.dao;

import com.cph.adminstration.model.Plane;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class PlaneDAO implements CRUD_DAO<Plane, Integer> {

    private final JdbcTemplate template;

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
        return null;
    }

    @Override
    public Plane getByID(Integer primaryKey) {
        return null;
    }

    @Override
    public void update(Plane plane) {

    }

    @Override
    public void delete(Integer primaryKey) {

    }
}
