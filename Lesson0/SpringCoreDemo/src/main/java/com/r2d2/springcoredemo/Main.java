package com.r2d2.springcoredemo;

import com.r2d2.springcoredemo.IoC.Employee;
import com.r2d2.springcoredemo.IoC.GeneralManager;
import com.r2d2.springcoredemo.IoC.Secretary;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        /*Este es un ejemplo de 'inversion of control', utilizando el aplication context de spring*/
        
        /*
        Employee employee = new GeneralManager();
        
        System.out.println(employee.getTask()); 
         */
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //empleado de tipo Secretary, con dependency injection en el constructor
        //funciona de la misma manera para un empleado de tipo AreaManager.
        Employee employee = context.getBean("myEmployee", Employee.class);
        
        //empleado de tipo GeneralManager, con dependency injection en un metodo setter
        Employee employee1 = context.getBean("GeneralManagerEmployee", Employee.class);

        System.out.println(employee.getTask());
        System.out.println(employee.getReport());
        
        System.out.println(employee1.getTask());
        System.out.println(employee1.getReport());
        
        
        
        
        /*Para singleton y prototype*/
        /*
        Secretary employee1 =  context.getBean("myEmployee", Secretary.class);
        GeneralManager employee =  context.getBean("GeneralManagerEmployee", GeneralManager.class);
        
        if(employee1.getReportMaker() == employee.getReportMaker()){
        
            System.out.println("Estamos trabajando con singleton");
        }else{
            
            System.out.println("Estamos trabajando con prototype");
        }*/
        
        context.close();

    }

}
