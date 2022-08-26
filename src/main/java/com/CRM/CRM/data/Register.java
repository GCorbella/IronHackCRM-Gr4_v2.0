package com.CRM.CRM.data;


import com.CRM.CRM.models.Hook;
import com.CRM.CRM.models.SalesRep;
import com.CRM.CRM.repositories.HookRepository;
import com.CRM.CRM.repositories.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Register {

    @Autowired
    InputHelper inputHelper;

   @Autowired
    HookRepository hookRepository;

    @Autowired
    SalesRepRepository salesRepRepository;


    //Código de Aldo
    public void newSalesRep() {
        String tempName = inputHelper.setName();
        SalesRep tempSalesRep=  new SalesRep(tempName);
        salesRepRepository.save(tempSalesRep);
    }

    public void newLead() {
        String tempName = inputHelper.setName();
        String tempPhoneNumber = inputHelper.setPhone();
        String tempEmail = inputHelper.setEmail();
        String tempCompanyName = inputHelper.setCompanyName();
        SalesRep tempSalesRep;

        if(inputHelper.salesRepRepository.findAll().isEmpty()) {
            System.out.println("\nThere is no sales rep in the database\nPlease create one");
            newSalesRep();
        }
        tempSalesRep = inputHelper.setSalesRep();

        Hook tempLead = new Hook(tempName, tempPhoneNumber, tempEmail, tempCompanyName, tempSalesRep);

        hookRepository.save(tempLead);
    }
}
