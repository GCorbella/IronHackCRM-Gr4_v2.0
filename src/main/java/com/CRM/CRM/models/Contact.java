package com.CRM.CRM.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Contact extends Lead{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "decisionMaker")
    private List<Opportunity> opportunities;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    //constructors
    public Contact() {
    }

    public Contact(String name, String phoneNumber, String email, String companyName, SalesRep salesRep, List<Opportunity> opportunities, Account account) {
        super(name, phoneNumber, email, companyName, salesRep);
        this.opportunities = opportunities;
        this.account = account;
    }

    //setters
    public void setOpportunities(List<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setId(int id) {
        this.id = id;
    }

    //getters
    public List<Opportunity> getOpportunities() {
        return opportunities;
    }

    public Account getAccount() {
        return account;
    }

    public int getId() {
        return id;
    }
}
