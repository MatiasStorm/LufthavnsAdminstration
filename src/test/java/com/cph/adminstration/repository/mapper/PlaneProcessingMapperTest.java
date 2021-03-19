package com.cph.adminstration.repository.mapper;

import com.cph.adminstration.model.PlaneProcessing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PlaneProcessingMapperTest {

    private PlaneProcessingMapper mapper = new PlaneProcessingMapper();

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
        PlaneProcessing planeProcessing = mapper.mapRow(resultSet, 1);
        assertEquals(work_id, planeProcessing.getWorkId());
        assertEquals(departudeID, planeProcessing.getDepartureId());
        assertEquals(arrivalID, planeProcessing.getArrivalId());
        LocalDateTime expectedStart =  LocalDateTime.of(start.getYear(), start.getMonth(), start.getDate(), start.getHours(),start.getMinutes(),start.getSeconds(),start.getNanos());
        LocalDateTime expectedEnd =  LocalDateTime.of(end.getYear(), end.getMonth(), end.getDate(), end.getHours(),end.getMinutes(),end.getSeconds(),end.getNanos());
        assertEquals(expectedStart, planeProcessing.getStart());
        assertEquals(expectedEnd, planeProcessing.getEnd());
        assertEquals(planeProcessingID, planeProcessing.getPlaneProcessingId());
    }

}