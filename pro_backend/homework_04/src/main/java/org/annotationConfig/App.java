package org.annotationConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main( String[] args ){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org/annotationConfig");

        TimePrinter printer = (TimePrinter) context.getBean("timePrinter");
        printer.print();



    }
}
