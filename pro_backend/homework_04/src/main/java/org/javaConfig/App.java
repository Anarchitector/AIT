package org.javaConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main( String[] args ){

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userServ = (UserService) context.getBean("UserServ");

        userServ.printUserName();
    }
}
