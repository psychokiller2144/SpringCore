package com.r2d2.springcoredemo.IoC;

import com.r2d2.springcoredemo.DepInj.ReportMaker;
import com.r2d2.springcoredemo.IoC.Employee;

public class AreaManager implements Employee{
    
    private ReportMaker reportMaker;
    
    
    public AreaManager(ReportMaker reportMaker){
        this.reportMaker = reportMaker;
    }
    
    
    @Override
    public String getTask() {
        return "I manage issues related to employees in my section.";
    }

    @Override
    public String getReport() {
        return "<report header> Report created by the area manager </report header>\n" + reportMaker.generateReport();
    }
    
}
