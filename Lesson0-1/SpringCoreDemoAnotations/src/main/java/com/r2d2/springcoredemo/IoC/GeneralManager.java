package com.r2d2.springcoredemo.IoC;

import com.r2d2.springcoredemo.DepInj.ReportMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//con esta anotacion, le decimos a spring que escanee la clase y la registre como un bean
//si se omite 'GeneralManager', el id seria el mismo nombre de la clase, pero sin la primer letra mayuscula
//es decir "generalManager"
@Component
public class GeneralManager implements Employee {
    
    //inclusive, es posible generar una inyeccion de dependencias directamente en un campo (atributo) de clase
    //@Autowired
    private ReportMaker reportMaker;

    public ReportMaker getReportMaker() {
        return reportMaker;
    }
    
    
    //mismo principio que la inyeccion por constructor
    //esto se generaliza a cualquier metodo, no tiene 
    //que ser estrictamente setter
    @Autowired
    @Qualifier("report")
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
