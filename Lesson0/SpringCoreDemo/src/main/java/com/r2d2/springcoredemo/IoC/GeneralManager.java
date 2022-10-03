package com.r2d2.springcoredemo.IoC;

import com.r2d2.springcoredemo.DepInj.ReportMaker;

public class GeneralManager implements Employee {

    private ReportMaker reportMaker;

    public ReportMaker getReportMaker() {
        return reportMaker;
    }

    public void setReportMaker(ReportMaker reportMaker) {
        this.reportMaker = reportMaker;
    }

    @Override
    public String getTask() {
        return "I manage all matters related to the company.";
    }

    @Override
    public String getReport() {
        return "<report header> Report created by the General Manager </report header>\n" + reportMaker.generateReport();
    }

}
