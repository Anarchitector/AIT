package org.xmlConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        MessageService messageService = (MessageService) context.getBean("messageService");

        System.out.println("Print data is - " + messageService.printMessage());

    }
}
