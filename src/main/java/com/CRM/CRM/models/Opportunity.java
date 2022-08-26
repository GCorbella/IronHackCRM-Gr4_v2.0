package com.CRM.CRM.models;

import com.CRM.CRM.models.enums.Product;
import com.CRM.CRM.models.enums.Status;

import javax.persistence.*;

@Entity
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "decision_maker_id")
    private Contact decisionMaker;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRep;

    //constructor
    public Opportunity() {
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }

    //getters
    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public Account getAccount() {
        return account;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }
}
