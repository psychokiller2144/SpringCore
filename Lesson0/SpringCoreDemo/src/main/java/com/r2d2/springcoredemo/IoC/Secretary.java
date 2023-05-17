package com.r2d2.springcoredemo.IoC;

import com.r2d2.springcoredemo.DepInj.ReportMaker;

public class Secretary implements Employee {

    private ReportMaker reportMaker;

    public Secretary() {
        
    }

    
    public ReportMaker getReportMaker() {
        return reportMaker;
    }

    public Secretary(ReportMaker reportMaker) {
        this.reportMaker = reportMaker;
    }

    @Override
    public String getTask() {
        return "I manage the agenda related to the manager of my section.";
    }

    @Override
    public String getReport() {
        return "<report header> Report created by the secretary </report header>\n" + reportMaker.generateReport();
    }

}
