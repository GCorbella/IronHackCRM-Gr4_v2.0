package com.CRM.CRM.models;


import com.CRM.CRM.repositories.MenuRepository;

public class Menu {

    private MenuRepository menuRepository;
    private String[] commands = {"help","new lead", "show leads", "convert", "close-lost", "close-won", "new salesrep", "report", "mean", "median", "max", "min", "quit"};
    private String[] reportCommands = {"by salesrep", "by product", "by country", "by city", "by industry"};
    private String[] mCommands = {"employeecount", "quantity", "opps per account"};
    private String[] sRCommands = {"leads", "opportunities", "closed-won", "closed-lost", "open"};

    //Codigo de Aldo

    //reports methods

    public void leadsBySalesRep() {
        System.out.println("These are the leads of every SalesRep:");
        System.out.println(menuRepository.findHooksBySalesRep());
    }

    public void opportunitiesBySalesRep() {
        System.out.println("These are the opportunities of every SalesRep:");
        System.out.println(menuRepository.findOpportunitiesBySalesRep());
    }

}
