package com.CRM.CRM.models;


import com.CRM.CRM.models.enums.Industry;

import javax.persistence.*;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    @OneToMany(mappedBy = "account")
    private List<Contact> contacts;
    @OneToMany(mappedBy = "account")
    private List<Opportunity> opportunities;

    //constructor
    public Account() {
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setOpportunities(List<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }

    //getters
    public int getId() {
        return id;
    }

    public Industry getIndustry() {
        return industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public List<Opportunity> getOpportunities() {
        return opportunities;
    }
}
