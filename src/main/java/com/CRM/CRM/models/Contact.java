package com.CRM.CRM.models;


import javax.persistence.*;
import java.util.List;

@Entity(name = "contacts")
public class Contact extends Hook {
    @OneToMany(mappedBy = "decisionMaker")
    private List<Opportunity> opportunities;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    //constructors
    public Contact() {
    }

    //setters
    public void setOpportunities(List<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    //getters
    public List<Opportunity> getOpportunities() {
        return opportunities;
    }

    public Account getAccount() {
        return account;
    }
}
