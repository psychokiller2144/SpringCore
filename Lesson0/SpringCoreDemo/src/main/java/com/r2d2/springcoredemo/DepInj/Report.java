package com.r2d2.springcoredemo.DepInj;

public class Report implements ReportMaker{

    @Override
    public String generateReport() {
        return "\t<report body> body of report should go here </report body>";
    }
    
}
