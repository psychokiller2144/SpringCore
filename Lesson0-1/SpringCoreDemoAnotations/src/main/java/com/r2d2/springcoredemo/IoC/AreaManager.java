package com.r2d2.springcoredemo.IoC;

import com.r2d2.springcoredemo.DepInj.ReportMaker;
import com.r2d2.springcoredemo.IoC.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


//con esta anotacion, le decimos a spring que escanee la clase y la registre como un bean
//si se omite 'AreaManager', el id seria el mismo nombre de la clase, pero sin la primer letra mayuscula
//es decir "areaManager"
@Component("AreaManager")
public class AreaManager implements Employee{
    
 
    private ReportMaker reportMaker;
    
    //Con esta anotacion le decimos a spring, que nos inyecte esta dependencia en el construcor
    //Spring busca en todo tu proyecto, una clase que implemente la interfaz ReportMaker, la cual es Report.
    //Como si existe, inyecta la dependencia

    //si se omite la anotacion seguira funcionando si y solo si esta clase (bean)
    //contiene solo un constructor
    
    
    public AreaManager(@Qualifier("report") ReportMaker reportMaker){
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
