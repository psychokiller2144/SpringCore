package com.r2d2.springcoredemo;

import com.r2d2.springcoredemo.IoC.Employee;
import com.r2d2.springcoredemo.IoC.Secretary;
import com.r2d2.springcoredemo.IoC.AreaManager;
import com.r2d2.springcoredemo.IoC.GeneralManager;

import com.r2d2.springcoredemo.DepInj.Report;
import com.r2d2.springcoredemo.DepInj.ReportMaker;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainIoC {

    public static void main(String[] args) {
        
        //Introduccion, mostramos un ejemeplo sencillo de IoC sin spring
        
        //podemos empezar teniendo un solo objeto GeneralManager, lo instanciamos y lo utilizamos, sin problema alguno
        //¿y si luego necesitamos un objeto AreaManager, o Secretary?, bueno tendriamos que cambiar el codigo como sigue:
        
        //GeneralManager generalManager = new GeneralManager();
        //AreaManager areaManager = new AreaManager();
        //Secretary secretary = new Secretary();
        
        //Naturalmente esto no es muy habil por nuestra parte, lo mejor es hacer una abstraccion y crear una interface Employee
        //Employee employee1 = new GeneralManager(); //new AreaManager(); //new Secretary();
        //System.out.println(employee1.getTask());
        
       /*------------------------------------------------------------------------------------------------------*/ 
       
        //COMENZAMOS CON IoC CON SPRING Y SU context.xml
        //Este es un ejemplo de 'inversion of control', utilizando el aplication context de spring
        
        //creamos el contexto
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextIoC.xml");
        
        
        //Le pedimos a spring que nos proporcione un objeto de tipo GeneralManager
        //¿y si luego necesitamos un objeto AreaManager, o Secretary?, bueno tendriamos que cambiar el XML como sigue:
        // com.r2d2.springcoredemo.IoC.AreaManager | com.r2d2.springcoredemo.IoC.Secretary
        // y listo, el codigo ya realizado queda igualito :D
        Employee employee1 = context.getBean("myEmployee", Employee.class);
        System.out.println(employee1.getTask());
        
        context.close();
    }

}
