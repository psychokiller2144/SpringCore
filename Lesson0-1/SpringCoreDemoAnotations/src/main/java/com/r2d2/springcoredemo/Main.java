package com.r2d2.springcoredemo;

import com.r2d2.springcoredemo.IoC.Employee;
import com.r2d2.springcoredemo.IoC.GeneralManager;
import com.r2d2.springcoredemo.IoC.Secretary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        
        
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        
        Employee employee = context.getBean("generalManager", Employee.class);
        
        
 
        System.out.println(employee.getTask());
        System.out.println(employee.getReport());
        
        
        /*
        //Configuracion basada en clases de java
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyClassConfig.class);
        Employee employee = context.getBean("secretaryReportCanceledAppointments", Employee.class);
        
        
        System.out.println(employee.getTask());
        System.out.println(employee.getReport());
        */
        context.close();

    }

}
