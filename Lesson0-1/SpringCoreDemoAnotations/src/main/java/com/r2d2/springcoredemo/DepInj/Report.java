package com.r2d2.springcoredemo.DepInj;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype") //para implementar el patron prototype
public class Report implements ReportMaker{

    @Override
    public String generateReport() {
        return " <report body> body of report should go here </report body>";
    }
    
}
