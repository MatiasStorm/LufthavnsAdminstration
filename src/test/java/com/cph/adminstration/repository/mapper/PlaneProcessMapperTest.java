package com.cph.adminstration.repository.mapper;

import com.cph.adminstration.model.PlaneProcess;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PlaneProcessMapperTest {

    private PlaneProcessMapper mapper = new PlaneProcessMapper();

    @Mock
    private ResultSet resultSet;

    int work_id =2;
    int departudeID =2;
    int arrivalID= 2;
    Timestamp start = new Timestamp(1020, 1, 1, 10, 0,0,0);
    Timestamp end = new Timestamp (1020, 1, 1, 10,10,0,0);
    int planeProcessingID = 2;

    @BeforeEach
    public void setup() throws SQLException {
        Mockito.when(resultSet.getInt("work_id")).thenReturn(work_id);
        Mockito.when(resultSet.getInt("departure_id")).thenReturn(departudeID);
        Mockito.when(resultSet.getInt("arrival_id")).thenReturn(arrivalID);
        Mockito.when(resultSet.getTimestamp("start")).thenReturn(start);
        Mockito.when(resultSet.getTimestamp("end")).thenReturn(end);
        Mockito.when(resultSet.getInt("plane_processing_id")).thenReturn(planeProcessingID);
    }

    @Test
    void mapRow() throws SQLException{
        PlaneProcess planeProcess = mapper.mapRow(resultSet, 1);
        assertEquals(work_id, planeProcess.getWork_id());
        assertEquals(departudeID, planeProcess.getDepartureId());
        assertEquals(arrivalID, planeProcess.getArrivalId());
        LocalDateTime expectedStart =  LocalDateTime.of(start.getYear(), start.getMonth(), start.getDate(), start.getHours(),start.getMinutes(),start.getSeconds(),start.getNanos());
        LocalDateTime expectedEnd =  LocalDateTime.of(end.getYear(), end.getMonth(), end.getDate(), end.getHours(),end.getMinutes(),end.getSeconds(),end.getNanos());
        assertEquals(expectedStart,planeProcess.getStart());
        assertEquals(expectedEnd,planeProcess.getEnd());
        assertEquals(planeProcessingID, planeProcess.getPlaneProcessingId());
    }

}