package com.CRM.CRM.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class SalesRep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "salesRep")
    private List<Lead> leads;
    @OneToMany(mappedBy = "salesRep")
    private List<Opportunity> opportunities;

    //constructor
    public SalesRep() {
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeads(List<Lead> leads) {
        this.leads = leads;
    }

    public void setOpportunities(List<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Lead> getLeads() {
        return leads;
    }

    public List<Opportunity> getOpportunities() {
        return opportunities;
    }
}
