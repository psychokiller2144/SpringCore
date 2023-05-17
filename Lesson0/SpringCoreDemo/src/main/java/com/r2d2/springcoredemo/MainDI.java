package com.r2d2.springcoredemo;

import com.r2d2.springcoredemo.DepInj.*;
import com.r2d2.springcoredemo.IoC.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainDI {

    public static void main(String[] args) {

        /*
        Podemos dotar de ciertos comportamientos a los objetos que ya tenemos
        La creacion de informes/reportes por ejemplo, obvio el reporte de un
        GeneralManager sera diferente del reporte de un AreaManager y de un Secretary.
        Este mecanismo que se encarga de realizar los informes, se convierte en una 
        dependencia para nuestros Objetos antes mencionados. 
         */
 /*
        //Para poder utilizar nuestra dependencia en un enfoque "clasico", primero instanciamos esa dependencia (ReportMaker)
        //Y luego en el constructor le pasamos el objeto necesite
        ReportMaker report = new Report();
        
        Employee employee0 = new AreaManager( report );
       
        System.out.println(employee0.getTask());
        System.out.println(employee0.getReport());
        
        //Y si necesitamos algun otro objeto, pues aplicamos la misma teoria, solo que en este caso, usaremos un metodo setter
        //Para que el GeneralManager pueda crear reportes.
        GeneralManager employee1 = new GeneralManager();
        employee1.setReportMaker( report );
        
          
        System.out.println(employee1.getTask());
        System.out.println(employee1.getReport());
         */
        //Ahora utilizamos la inversion de control para obtener objetos de tipo Employee, y tambien usamos la 
        //inyeccion de dependencias para que el objeto recie creado, ya tenga una instancia de ReportMaker.
        //En este caso, en nuestros objetos AreaManager y Secretary estamos inyectando la dependencia por 
        //medio del constructor. Para cambiar de AreaManager a Secretary, literalmente solo debemos de cambiarlo 
        //en nuestro archivo context.xml
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextDI.xml");

        Employee employee0 = context.getBean("myEmployee", Employee.class);

        System.out.println(employee0.getTask());
        System.out.println(employee0.getReport());

        //Seguimos con el enfoque de la inyeccion de dependencias, pero ahora obtenemos un objeto de tipo GeneralManager
        //Y le inyectamos la dependencia por medio de un metodo setter, para que pueda crear reportes.
        Employee employee1 = context.getBean("GeneralManagerEmployee", Employee.class);

        //para que funcione la DI de campos email y companyName
        //GeneralManager employee1 = context.getBean("GeneralManagerEmployee", GeneralManager.class);
        //System.out.println(employee1.getCompanyName());
        //System.out.println(employee1.getEmail());
        System.out.println(employee1.getTask());
        System.out.println(employee1.getReport());

        /*Para singleton y prototype*/
        /*
            Secretary employee2 = context.getBean("myEmployee", Secretary.class);
            GeneralManager employee3 = context.getBean("GeneralManagerEmployee", GeneralManager.class);

            System.out.println(employee2.getReportMaker());
            System.out.println(employee3.getReportMaker());

            if (employee2.getReportMaker() == employee3.getReportMaker()) {

                System.out.println("Estamos trabajando con singleton");
            } else {

                System.out.println("Estamos trabajando con prototype");
            }
        */
        context.close();

    }

}
