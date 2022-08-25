package com.CRM.CRM.data;


import com.CRM.CRM.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@Component
public class Menu {

    @Autowired
    Register register;

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    HookRepository hookRepository;
    @Autowired
    OpportunityRepository opportunityRepository;
    @Autowired
    SalesRepRepository salesRepRepository;

    // List of all commandMenu
    private final String[] commandMenu = new String[]{
            "\nTABLE OF COMMANDS:",
            "\n Example of use ->  new salesRep ",
            //console encoding
            "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500" +
                    "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500"+
            "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500" +
                    "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500"+
                    "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500",
            "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500" +
                    "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500"+
                    "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500" +
                    "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500"+
                    "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500",
            "- new <>          |     <lead> or <salesRep>      |",
            "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500",
            "- show <>         |     <leads> or <salesReps>    |",
            "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500",
            "- lookup <> {Id}  |     <lead> or <opportunity>   | {Id} from lead or opportunity",
            "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500",
            "- convert {Id}    |                               |",
            "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500",
            "- close-<>  {Id}  |     <lost> or <won>           |",
            "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500",
            "                  |     <lead> , <opportunity>    |",
            "- report <> by {} |     <open> , <close-won>      | {}: salesRep / product / country / city / industry",
            "                  |     <close-lost>              |",
            "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500",
            "mean by {}        |                               | {}: EmployeeCount / Quantity / Opps per Account",
            "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500",
            "help",
            "quit\n"
    };

    final String notValidCommand = "\nPlease enter a valid command\nType help for all available commands";
    private static ArrayList<String> commandArray = new ArrayList<>();
    private static String fullCommand;


    public void start() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\r*** Welcome to CRM of Group 4***");
         Thread.sleep(1000);

        while (true){
            System.out.println("\nPlease type help to see all commands:");
            commandArray.clear(); //
            commandArray.addAll(Arrays.asList(scanner.nextLine().toLowerCase().trim().split(" ")));
            fullCommand = String.join(" ", commandArray);

            switch (commandArray.get(0)) {

                case (""):
                    break;

                case ("new"):
                    // Create new lead or new salesRep
                    if(fullCommand.equals("new lead")) register.newLead();
                    else if(fullCommand.equals("new salesrep")) register.newSalesRep();
                    else System.out.println(notValidCommand);
                    break;

                case ("lookup"):
                    // Search single registry
                    if(fullCommand.matches("lookup lead [0-9]+")) {
                        //findLead(commandArray.get(2));
                    }
                    else if(fullCommand.matches("lookup opportunity [0-9]+")){
                        //findOpportunity(commandArray.get(2));
                    }
                    else System.out.println(notValidCommand);
                    break;

                case ("show"):
                    // Search for all registries
                    if(fullCommand.matches("show leads"))
                        //hookRepository.findAllLeads();
                        hookRepository.findAll();
                    if(fullCommand.matches("show salesReps")) {
                        //salesRepRepository.findAllSalesReps();
                        salesRepRepository.findAll();

                    }
                    else System.out.println(notValidCommand);
                    break;

                case ("convert"):
                    // Convert lead to opportunity
                    if(fullCommand.matches("convert [0-9]+")){
                        //hookRepository.convertLead(commandArray.get(1));
                    }
                    else System.out.println(notValidCommand);
                    break;

                case ("close-won"):
                case ("close-lost"):
                    // Close
                    if(fullCommand.matches("close-won [0-9]+")){// .closeWon(commandArray.get(1));
                         }
                    else if(fullCommand.matches("close-lost [0-9]")){

                       // .closeLost(commandArray.get(1));
                    }
                    else System.out.println(notValidCommand);
                    break;

                case ("report"):
                    // Report

                    /*
                    if(fullCommand.matches("report lead by salesrep")) hookRepository.findLeadsBySalesRep();
                    else if(fullCommand.matches("report opportunity by salesrep")) opportunityRepository.findOpportunitiesBySalesRep();
                    else if(fullCommand.matches("report closed-won by salesrep"))opportunityRepository.findWonOpportunitiesBySalesRep();
                    else if(fullCommand.matches("report closed-lost by salesrep"))opportunityRepository.findLostOpportunitiesBySalesRep();
                    else if(fullCommand.matches("report open by salesrep")) opportunityRepository.findOpenOpportunitiesBySalesRep();
                    else if(fullCommand.matches("report opportunity by product")) opportunityRepository.countByProduct();
                    else if(fullCommand.matches("report closed-won by product")) opportunityRepository.countWonByProduct();
                    else if(fullCommand.matches("report closed-lost by product")) opportunityRepository.countLostByProduct();
                    else if(fullCommand.matches("report open by product")) opportunityRepository.countOpenByProduct();
                    else if(fullCommand.matches("report opportunity by country")) opportunityRepository.countByCountry();
                    else if(fullCommand.matches("report closed-won by country")) opportunityRepository.countWonByCountry();
                    else if(fullCommand.matches("report closed-lost by country")) opportunityRepository.countLostByCountry();
                    else if(fullCommand.matches("report open by country")) opportunityRepository.countOpenByCountry();
                    else if(fullCommand.matches("report opportunity by city")) opportunityRepository.countByCity();
                    else if(fullCommand.matches("report closed-won by city")) opportunityRepository.countWonByCity();
                    else if(fullCommand.matches("report closed-lost by city")) opportunityRepository.countLostByCity();
                    else if(fullCommand.matches("report open by city")) opportunityRepository.countOpenByCity();
                    else if(fullCommand.matches("report opportunity by industry")) opportunityRepository.countByIndustry();
                    else if(fullCommand.matches("report closed-won by industry")) opportunityRepository.countWonByIndustry();
                    else if(fullCommand.matches("report closed-lost by industry")) opportunityRepository.countLostByIndustry();
                    else if(fullCommand.matches("report open by industry")) opportunityRepository.countOpenByIndustry();
                    else System.out.println(notValidCommand);
*/
                    break;

                case ("mean"):
                case ("median"):
                case ("max"):
                case ("min"):
                    if(fullCommand.matches("mean employeecount")) {
                        //opportunityRepository.meanEmployeeCount();
                    }
         /*           else if(fullCommand.matches("median employeecount")) opportunityRepository.medianEmployeeCount();
                    else if(fullCommand.matches("max employeecount")) opportunityRepository.maxEmployeeCount();
                    else if(fullCommand.matches("min employeecount")) opportunityRepository.minEmployeeCount();
                    else if(fullCommand.matches("mean quantity")) opportunityRepository.meanQuantity();
                    else if(fullCommand.matches("median quantity")) opportunityRepository.medianQuantity();
                    else if(fullCommand.matches("max quantity")) opportunityRepository.maxQuantity();
                    else if(fullCommand.matches("min quantity")) opportunityRepository.minQuantity();
                    else if(fullCommand.matches("mean opps per account")) opportunityRepository.meanOpportunityByAccount();
                    else if(fullCommand.matches("median opps per account")) opportunityRepository.medianOpportunityByAccount();
                    else if(fullCommand.matches("max opps per account")) opportunityRepository.maxOppsByAccount();
                    else if(fullCommand.matches("min opps per account")) opportunityRepository.minOppsByAccount();*/
                    else System.out.println(notValidCommand);

                    break;
                case ("help"):
                    // Help
                    for (String singleCommand : commandMenu) {
                        System.out.println(singleCommand);
                    }
                    break;

                case ("quit"):
                    scanner.close();
                    System.out.println("\nGoodbye!");
                    System.exit(0);

                default:
                    System.out.println(notValidCommand);
            }
        }
    }
}



