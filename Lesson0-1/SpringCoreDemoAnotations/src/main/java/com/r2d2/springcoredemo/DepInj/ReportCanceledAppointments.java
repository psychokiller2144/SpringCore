package com.r2d2.springcoredemo.DepInj;

public class ReportCanceledAppointments implements ReportMaker{

    @Override
    public String generateReport() {
        return " <report body> this month's canceled appointments are.. </report body>";
    }
    
}
