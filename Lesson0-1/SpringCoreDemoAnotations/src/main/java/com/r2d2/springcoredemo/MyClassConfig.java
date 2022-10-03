package com.r2d2.springcoredemo;

import com.r2d2.springcoredemo.DepInj.ReportCanceledAppointments;
import com.r2d2.springcoredemo.DepInj.ReportMaker;
import com.r2d2.springcoredemo.IoC.Employee;
import com.r2d2.springcoredemo.IoC.Secretary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.r2d2.springcoredemo")
public class MyClassConfig {
    
    //el nombre del metodo, representa el id del bean
    //es decir cuando solicites un bean, se introduce el nombre del metodo
    @Bean
    public ReportMaker reportCanceledAppointments(){
        return new ReportCanceledAppointments();
    }
    
    @Bean
    public Employee secretaryReportCanceledAppointments(){
        
        return new Secretary(reportCanceledAppointments());
    }
}
