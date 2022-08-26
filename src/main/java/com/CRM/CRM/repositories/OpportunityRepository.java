package com.CRM.CRM.repositories;

import com.CRM.CRM.models.Account;
import com.CRM.CRM.models.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {


    //A count of all Opportunities by SalesRep
    @Query(value = "SELECT sales_rep.name, COUNT(opportunity.id) FROM opportunity JOIN sales_rep ON opportunity.sales_rep_id = sales_rep.id GROUP BY sales_rep_id",nativeQuery = true)
    List<Object[]> findOpportunitiesBySalesRep();

    //A count of all CLOSED_WON Opportunities by SalesRep
    @Query(value = "SELECT sales_rep.name, COUNT(opportunity.id) FROM opportunity JOIN sales_rep ON opportunity.sales_rep_id = sales_rep.id WHERE opportunity.status = CLOSED_WON GROUP BY sales_rep_id",nativeQuery = true)
    List<Object[]> findAllClosedWonOpportunitiesBySalesRep();

    //A count of all CLOSED_LOST Opportunities by SalesRep
    @Query(value = "SELECT sales_rep.name, COUNT(opportunity.id) FROM opportunity JOIN sales_rep ON opportunity.sales_rep_id = sales_rep.id WHERE opportunity.status = CLOSED_LOST GROUP BY sales_rep_id",nativeQuery = true)
    List<Object[]> findAllClosedLostOpportunitiesBySalesRep();

    //A count of all OPEN Opportunities by SalesRep
    @Query(value ="SELECT sales_rep.name, COUNT(opportunity.id) FROM opportunity JOIN sales_rep ON opportunity.sales_rep_id = sales_rep.id WHERE opportunity.status = OPEN  GROUP BY sales_rep_id", nativeQuery = true)
    List<Object[]> findAllOpenOpportunitiesBySalesRep();




    //A count of all Opportunities by the product
    @Query(value = "SELECT product, COUNT(id) FROM opportunity GROUP BY product",nativeQuery = true)
    List<Object[]> findAllOpportunitiesByProduct();

    //A count of all CLOSED_WON Opportunities by the product
    @Query(value = "SELECT product, COUNT(id) FROM opportunity WHERE status=CLOSED_WON GROUP BY product",nativeQuery = true)
    List<Object[]> findAllClosedWonOpportunitiesByProduct();

    //A count of all CLOSED_LOST Opportunities by the product
    @Query(value = "SELECT product, COUNT(id) FROM opportunity WHERE status=CLOSED_LOST GROUP BY product",nativeQuery = true)
    List<Object[]> findAllClosedLostOpportunitiesByProduct();

    //A count of all OPEN Opportunities by the product
    @Query(value = "SELECT product, COUNT(id) FROM opportunity WHERE status=OPEN GROUP BY product",nativeQuery = true)
    List<Object[]> findAllOpenOpportunitiesByProduct();

    //A count of all Opportunities by country
    @Query(value = "SELECT account.country, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account GROUP BY account.country",nativeQuery = true)
    List<Object[]> findAllOpportunitiesByCountry();

    //A count of all CLOSED_WON Opportunities by country
    @Query(value = "SELECT account.country, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account WHERE opportunity.status = CLOSED_WON GROUP BY account.country",nativeQuery = true)
    List<Object[]> findAllClosedWonOpportunitiesByCountry();

    //A count of all CLOSED_LOST Opportunities by country
    @Query(value = "SELECT account.country, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account WHERE opportunity.status = CLOSED_LOST GROUP BY account.country",nativeQuery = true)
    List<Object[]> findAllClosedLostOpportunitiesByCountry();

    //A count of all OPEN Opportunities by country
    @Query(value = "SELECT account.country, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account WHERE opportunity.status = OPEN GROUP BY account.country",nativeQuery = true)
    List<Object[]> findAllOpenOpportunitiesByCountry();

    //A count of all Opportunities by the city
    @Query(value = "SELECT account.city, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account GROUP BY account.city",nativeQuery = true)
    List<Object[]> findAllOpportunitiesByCity();

    //A count of all CLOSED_WON Opportunities by the city
    @Query(value = "SELECT account.city, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account WHERE opportunity.status = CLOSED_WON GROUP BY account.city",nativeQuery = true)
    List<Object[]> findAllClosedWonOpportunitiesByCity();

    //A count of all CLOSED_LOST Opportunities by the city
    @Query(value = "SELECT account.city, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account WHERE opportunity.status = CLOSED_LOST GROUP BY account.city",nativeQuery = true)
    List<Object[]> findAllClosedLostOpportunitiesByCity();

    //A count of all OPEN Opportunities by the city
    @Query(value = "SELECT account.city, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account WHERE opportunity.status = OPEN GROUP BY account.city",nativeQuery = true)
    List<Object[]> findAllOpenOpportunitiesByCity();

    //A count of all Opportunities by industry
    @Query(value = "SELECT industry, COUNT(id) FROM opportunity GROUP BY industry",nativeQuery = true)
    List<Object[]> findAllOpportunitiesByIndustry();

    //A count of all CLOSED_WON Opportunities by industry
    @Query(value = "SELECT industry, COUNT(id) FROM opportunity WHERE status = CLOSED_WON GROUP BY industry",nativeQuery = true)
    List<Object[]> findAllClosedWonOpportunitiesByIndustry();

    //A count of all CLOSED_LOST Opportunities by industry
    @Query(value = "SELECT industry, COUNT(id) FROM opportunity WHERE status = CLOSED_LOST GROUP BY industry",nativeQuery = true)
    List<Object[]> findAllClosedLostOpportunitiesByIndustry();

    //A count of all OPEN Opportunities by industry
    @Query(value = "SELECT industry, COUNT(id) FROM opportunity WHERE status = OPEN GROUP BY industry",nativeQuery = true)
    List<Object[]> findAllOpenOpportunitiesByIndustry();


    //mean employeeCount
    @Query(value = "SELECT AVG (employee_count) FROM account AS mean_employee_count",nativeQuery = true)
    Optional<Account> findEmployeeCountAverage();

    //median employeeCount
    @Query(value = "SELECT employee_count PERCENTILE_CONT(0.5) FROM account AS median_employee_count",nativeQuery = true)
    Optional<Account> findEmployeeCountMedian();

    //maximum employeeCount
    @Query(value = "SELECT MAX(employee_count)  FROM account AS max_employee_count",nativeQuery = true)
    Optional<Account> findEmployeeCountMax();

    //minimum employeeCount
    @Query(value = "SELECT MIN(employee_count)  FROM account AS min_employee_count",nativeQuery = true)
    Optional<Account> findEmployeeCountMin();

    //mean quantity of products order
    @Query(value = "SELECT AVG (product) FROM opportunity AS mean_product_quantity",nativeQuery = true)
    Optional<Opportunity> findProductQuantityAverage();

    //median quantity of products order
    @Query(value = "SELECT product PERCENTILE_CONT(0.5) FROM opportunity AS median_product_quantity",nativeQuery = true)
    Optional<Opportunity> findProductQuantityMedian();

    //maximum quantity of products order
    @Query(value = "SELECT MAX (product) FROM opportunity AS max_product_quantity",nativeQuery = true)
    Optional<Opportunity> findProductQuantityMax();

    //minimum quantity of products order
    @Query(value = "SELECT MIN (product) FROM opportunity AS min_product_quantity",nativeQuery = true)
    Optional<Opportunity> findProductQuantityMin();

    //mean number of Opportunities associated with an Account
    @Query(value = "SELECT AVG (opportunities) FROM account AS mean_opportunities_per_account",nativeQuery = true)
    Optional<Account> findOpportunitiesPerAccountAverage();

    //median number of Opportunities associated with an Account
    @Query(value = "SELECT opportunities PERCENTILE_CONT(0.5) FROM account AS median_opportunities_per_account",nativeQuery = true)
    Optional<Account> findOpportunitiesPerAccountMedian();

    //maximum number of Opportunities associated with an Account
    @Query(value = "SELECT MAX (opportunities) FROM account AS max_opportunities_per_account",nativeQuery = true)
    Optional<Account> findOpportunitiesPerAccountMax();

    //minimum number of Opportunities associated with an Account
    @Query(value = "SELECT MIN (opportunities) FROM account AS min_opportunities_per_account",nativeQuery = true)
    Optional<Account> findOpportunitiesPerAccountMin();




}
