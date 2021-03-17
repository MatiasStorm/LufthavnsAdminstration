package com.cph.adminstration.repository.mapper;

import com.cph.adminstration.model.Arrival;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ArrivalMapperTest {
    private ArrivalMapper mapper = new ArrivalMapper();
    @Mock
    private ResultSet resultSet;

    int id = 1;
    Date date = new Date(2019, 1, 1);
    Time time = new Time(10, 0, 0);
    String routeNumber = "QNP";
    String ac = "123";
    String destination = "KRK";
    boolean isArrived = false;


    @BeforeEach
    public void setup() throws SQLException{
        Mockito.when(resultSet.getInt("arrival_id")).thenReturn(id);
        Mockito.when(resultSet.getDate("arrival_date")).thenReturn(date);
        Mockito.when(resultSet.getTime("arrival_time")).thenReturn(time);
        Mockito.when(resultSet.getString("route_number")).thenReturn(routeNumber);
        Mockito.when(resultSet.getString("arrival_ac")).thenReturn(ac);
        Mockito.when(resultSet.getString("arrival_destination")).thenReturn(destination);
        Mockito.when(resultSet.getBoolean("is_arrived")).thenReturn(isArrived);
    }

    @Test
    void mapRow() throws SQLException {
        Arrival arrival = mapper.mapRow(resultSet, 1);
        assertEquals(id, arrival.getId());
        LocalDateTime dateTime = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDate(), time.getHours(), time.getMinutes(),time.getSeconds());
        assertEquals(arrival.getDateTime(), dateTime);
        assertEquals(arrival.getRouteNumber(), routeNumber);
        assertEquals(arrival.getAc(), ac);
        assertEquals(arrival.getDestination(), destination);
        assertEquals(arrival.getIsArrived(), isArrived);
    }
}