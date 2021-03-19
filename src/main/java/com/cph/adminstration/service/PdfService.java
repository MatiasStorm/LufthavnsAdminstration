package com.cph.adminstration.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import com.cph.adminstration.model.Arrival;
import com.cph.adminstration.model.DailyPlanning;
import com.cph.adminstration.model.Departure;
import com.cph.adminstration.repository.dao.ArrivalDAO;
import com.cph.adminstration.repository.dao.DepartureDAO;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

@Service
public class PdfService {
    private final ArrivalDAO arrivalDAO;
    private final DepartureDAO departureDAO;
    private List<DailyPlanning> dailyPlannings = new ArrayList<>();

    public PdfService(ArrivalDAO arrivalDAO, DepartureDAO departureDAO){
        this.arrivalDAO = arrivalDAO;
        this.departureDAO = departureDAO;
    }

    public void createPdf() throws FileNotFoundException, DocumentException {
        List<Arrival> arrivals = arrivalDAO.readAll();
        List<Departure> departures = departureDAO.readAll();
        dailyPlannings.addAll(arrivals);
        dailyPlannings.addAll(departures);

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("iTextTable.pdf"));

        document.open();

        PdfPTable table = new PdfPTable(3);
        addTableHeader(table);
        for (DailyPlanning dailyPlanning : dailyPlannings) {
            addRows(table, dailyPlanning);
        }


        document.add(table);
        document.close();
    }

    private void addTableHeader(PdfPTable table) {
        Stream.of("Date & Time", "Arrive/Depature", "A/C")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }
    private void addRows(PdfPTable table, DailyPlanning dailyPlanning) {
        String dt = dailyPlanning.getDateTime().toString();
        dt = dt.replace('T', ' ');
        table.addCell(dt);
        if (dailyPlanning.getTravelType().equals("Arrival")){
            table.addCell("Arrival");
        } else {
            table.addCell("Departure");
        }

        table.addCell(dailyPlanning.getAc());
    }


}
