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
    private List<Hook> hooks;
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

    public void setHooks(List<Hook> hooks) {
        this.hooks = hooks;
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

    public List<Hook> getHooks() {
        return hooks;
    }

    public List<Opportunity> getOpportunities() {
        return opportunities;
    }
}
