package app.code;

import app.staff.administration.ProductionChief;
import app.staff.administration.SalesChief;
import app.staff.specialists.production.MachineOperator;
import app.staff.specialists.production.Storekeeper;
import app.staff.specialists.sales.Merchandiser;
import app.staff.specialists.sales.SalesManager;
import app.staff.administration.Director;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Application {

    public static void main(String[] args)
    {
        // Вариант кода без использования Spring
//        MachineOperator machineOperator = new MachineOperator();
//        Storekeeper storekeeper = new Storekeeper();
//
//        Merchandiser merchandiser = new Merchandiser();
//        SalesManager salesManager = new SalesManager();
//
//        ProductionChief productionChief = new ProductionChief();
//        productionChief.setMachineOperator(machineOperator);
//        productionChief.setStorekeeper(storekeeper);
//
//        SalesChief salesChief = new SalesChief();
//        salesChief.setMerchandiser(merchandiser);
//        salesChief.setSalesManager(salesManager);
//        Director director = new Director();
//
//        director.manageCompany();


        //Вариант кода с использованием Spring
        AbstractApplicationContext context = new AnnotationConfigApplicationContext("app.config");
        Director director = context.getBean(Director.class);
        director.manageCompany();
    }

}
