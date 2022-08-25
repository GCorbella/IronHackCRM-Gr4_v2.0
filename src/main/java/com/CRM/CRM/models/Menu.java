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

    public void closedWonBySalesRep() {
        System.out.println("These are the opportunities CLOSE-WON of every SalesRep:");
        System.out.println(menuRepository.findAllClosedWonOpportunitiesBySalesRep());
    }

    public void closedLostBySalesRep() {
        System.out.println("These are the opportunities CLOSE-LOST of every SalesRep:");
        System.out.println(menuRepository.findAllClosedLostOpportunitiesBySalesRep());
    }

    public void openBySalesRep() {
        System.out.println("These are the opportunities OPEN of every SalesRep:");
        System.out.println(menuRepository.findAllOpenOpportunitiesBySalesRep());
    }

    public void allOpportunitiesByProduct() {
        System.out.println("These are all opportunities of every Product:");
        System.out.println(menuRepository.findAllOpportunitiesByProduct());
    }

    public void allClosedWonByProduct() {
        System.out.println("These are all opportunities CLOSED-WON of every Product:");
        System.out.println(menuRepository.findAllClosedWonOpportunitiesByProduct());
    }

    public void allClosedLostByProduct() {
        System.out.println("These are all opportunities CLOSED-LOST of every Product:");
        System.out.println(menuRepository.findAllClosedLostOpportunitiesByProduct());
    }

    public void allOpenByProduct() {
        System.out.println("These are all opportunities OPEN of every Product:");
        System.out.println(menuRepository.findAllOpenOpportunitiesByProduct());
    }

    public void allOpportunitiesByCountry() {
        System.out.println("These are all opportunities sorted by country:");
        System.out.println(menuRepository.findAllOpportunitiesByCountry());
    }

    public void allClosedWonByCountry() {
        System.out.println("These are all opportunities CLOSED-WON sorted by country:");
        System.out.println(menuRepository.findAllClosedWonOpportunitiesByCountry());
    }

    public void allClosedLostByCountry() {
        System.out.println("These are all opportunities CLOSED-LOST sorted by country:");
        System.out.println(menuRepository.findAllClosedLostOpportunitiesByCountry());
    }

    public void allOpenByCountry() {
        System.out.println("These are all opportunities OPEN sorted by country:");
        System.out.println(menuRepository.findAllOpenOpportunitiesByCountry());
    }

    public void allOpportunitiesByCity() {
        System.out.println("These are all opportunities sorted by city:");
        System.out.println(menuRepository.findAllOpportunitiesByCity());
    }

    public void allClosedWonByCity() {
        System.out.println("These are all opportunities CLOSED-WON sorted by city:");
        System.out.println(menuRepository.findAllClosedWonOpportunitiesByCity());
    }

    public void allClosedLostByCity() {
        System.out.println("These are all opportunities CLOSED-LOST sorted by city:");
        System.out.println(menuRepository.findAllClosedLostOpportunitiesByCity());
    }

    public void allOpenByCity() {
        System.out.println("These are all opportunities OPEN sorted by city:");
        System.out.println(menuRepository.findAllOpenOpportunitiesByCity());
    }

    public void allOpportunitiesByIndustry() {
        System.out.println("These are all opportunities sorted by industry:");
        System.out.println(menuRepository.findAllOpportunitiesByIndustry());
    }

    public void allClosedWonByIndustry() {
        System.out.println("These are all opportunities CLOSED-WON sorted by industry:");
        System.out.println(menuRepository.findAllClosedWonOpportunitiesByIndustry());
    }

    public void allClosedLostByIndustry() {
        System.out.println("These are all opportunities CLOSED-LOST sorted by industry:");
        System.out.println(menuRepository.findAllClosedLostOpportunitiesByIndustry());
    }

    public void allOpenByIndustry() {
        System.out.println("These are all opportunities OPEN sorted by industry:");
        System.out.println(menuRepository.findAllOpenOpportunitiesByIndustry());
    }

    public void meanEmployees() {
        System.out.println("This is the mean quantity of employees:");
        System.out.println(menuRepository.findEmployeeCountAverage());
    }

    public void medianEmployees() {
        System.out.println("This is the median quantity of employees:");
        System.out.println(menuRepository.findEmployeeCountMedian());
    }

    public void maxEmployees() {
        System.out.println("This is the maximum quantity of employees:");
        System.out.println(menuRepository.findEmployeeCountMax());
    }

    public void minEmployees() {
        System.out.println("This is the minimum quantity of employees:");
        System.out.println(menuRepository.findEmployeeCountMin());
    }

    public void meanQuantity() {
        System.out.println("This is the mean quantity of product orders:");
        System.out.println(menuRepository.findProductQuantityAverage());
    }

    public void medianQuantity() {
        System.out.println("This is the median quantity of product orders:");
        System.out.println(menuRepository.findProductQuantityMedian());
    }

    public void maxQuantity() {
        System.out.println("This is the maximum quantity of product orders:");
        System.out.println(menuRepository.findProductQuantityMax());
    }

    public void minQuantity() {
        System.out.println("This is the minimum quantity of product orders:");
        System.out.println(menuRepository.findProductQuantityMin());
    }

    public void meanOpportunity() {
        System.out.println("This is the mean quantity of opportunities of the account:");
        System.out.println(menuRepository.findOpportunitiesPerAccountAverage());
    }

    public void medianOpportunity() {
        System.out.println("This is the median quantity of opportunities of the account:");
        System.out.println(menuRepository.findOpportunitiesPerAccountMedian());
    }

    public void maxOpportunity() {
        System.out.println("This is the maximum quantity of opportunities of the account:");
        System.out.println(menuRepository.findOpportunitiesPerAccountMax());
    }

    public void minOpportunity() {
        System.out.println("This is the minimum quantity of opportunities of the account:");
        System.out.println(menuRepository.findOpportunitiesPerAccountMin());
    }
}
