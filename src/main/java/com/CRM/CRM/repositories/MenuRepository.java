package com.CRM.CRM.repositories;

import com.CRM.CRM.models.Account;
import com.CRM.CRM.models.Hook;
import com.CRM.CRM.models.Opportunity;
import com.CRM.CRM.models.SalesRep;
import com.CRM.CRM.models.enums.Industry;
import com.CRM.CRM.models.enums.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository {

    //A count of Leads by SalesRep
    @Query("SELECT sales_rep.name, COUNT(hook.id) FROM hook JOIN sales_rep ON hook.sales_rep_id = sales_rep.id GROUP BY sales_rep_id")
    List<Object[]> findHooksBySalesRep ();

    //A count of all Opportunities by SalesRep
    @Query("SELECT sales_rep.name, COUNT(opportunity.id) FROM opportunity JOIN sales_rep ON opportunity.sales_rep_id = sales_rep.id GROUP BY sales_rep_id")
    List<Object[]> findOpportunitiesBySalesRep();

    //A count of all CLOSED_WON Opportunities by SalesRep
    @Query("SELECT sales_rep.name, COUNT(opportunity.id) FROM opportunity JOIN sales_rep ON opportunity.sales_rep_id = sales_rep.id WHERE opportunity.status = CLOSED_WON GROUP BY sales_rep_id")
    List<Object[]> findAllClosedWonOpportunitiesBySalesRep();

    //A count of all CLOSED_LOST Opportunities by SalesRep
    @Query("SELECT sales_rep.name, COUNT(opportunity.id) FROM opportunity JOIN sales_rep ON opportunity.sales_rep_id = sales_rep.id WHERE opportunity.status = CLOSED_LOST GROUP BY sales_rep_id")
    List<Object[]> findAllClosedLostOpportunitiesBySalesRep();

    //A count of all OPEN Opportunities by SalesRep
    @Query("SELECT sales_rep.name, COUNT(opportunity.id) FROM opportunity JOIN sales_rep ON opportunity.sales_rep_id = sales_rep.id WHERE opportunity.status = OPEN  GROUP BY sales_rep_id")
    List<Object[]> findAllOpenOpportunitiesBySalesRep();

    //A count of all Opportunities by the product
    @Query("SELECT product, COUNT(id) FROM opportunity GROUP BY product")
    List<Object[]> findAllOpportunitiesByProduct();

    //A count of all CLOSED_WON Opportunities by the product
    @Query("SELECT product, COUNT(id) FROM opportunity WHERE status=CLOSED_WON GROUP BY product")
    List<Object[]> findAllClosedWonOpportunitiesByProduct();

    //A count of all CLOSED_LOST Opportunities by the product
    @Query("SELECT product, COUNT(id) FROM opportunity WHERE status=CLOSED_LOST GROUP BY product")
    List<Object[]> findAllClosedLostOpportunitiesByProduct();

    //A count of all OPEN Opportunities by the product
    @Query("SELECT product, COUNT(id) FROM opportunity WHERE status=OPEN GROUP BY product")
    List<Object[]> findAllOpenOpportunitiesByProduct();

    //A count of all Opportunities by country
    @Query("SELECT account.country, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account GROUP BY account.country")
    List<Object[]> findAllOpportunitiesByCountry();

    //A count of all CLOSED_WON Opportunities by country
    @Query("SELECT account.country, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account WHERE opportunity.status = CLOSED_WON GROUP BY account.country")
    List<Object[]> findAllClosedWonOpportunitiesByCountry();

    //A count of all CLOSED_LOST Opportunities by country
    @Query("SELECT account.country, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account WHERE opportunity.status = CLOSED_LOST GROUP BY account.country")
    List<Object[]> findAllClosedLostOpportunitiesByCountry();

    //A count of all OPEN Opportunities by country
    @Query("SELECT account.country, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account WHERE opportunity.status = OPEN GROUP BY account.country")
    List<Object[]> findAllOpenOpportunitiesByCountry();

    //A count of all Opportunities by the city
    @Query("SELECT account.city, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account GROUP BY account.city")
    List<Object[]> findAllOpportunitiesByCity();

    //A count of all CLOSED_WON Opportunities by the city
    @Query("SELECT account.city, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account WHERE opportunity.status = CLOSED_WON GROUP BY account.city")
    List<Object[]> findAllClosedWonOpportunitiesByCity();

    //A count of all CLOSED_LOST Opportunities by the city
    @Query("SELECT account.city, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account WHERE opportunity.status = CLOSED_LOST GROUP BY account.city")
    List<Object[]> findAllClosedLostOpportunitiesByCity();

    //A count of all OPEN Opportunities by the city
    @Query("SELECT account.city, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account WHERE opportunity.status = OPEN GROUP BY account.city")
    List<Object[]> findAllOpenOpportunitiesByCity();

    //A count of all Opportunities by industry
    @Query("SELECT industry, COUNT(id) FROM opportunity GROUP BY industry")
    List<Object[]> findAllOpportunitiesByIndustry();

    //A count of all CLOSED_WON Opportunities by industry
    @Query("SELECT industry, COUNT(id) FROM opportunity WHERE status = CLOSED_WON GROUP BY industry")
    List<Object[]> findAllClosedWonOpportunitiesByIndustry();

    //A count of all CLOSED_LOST Opportunities by industry
    @Query("SELECT industry, COUNT(id) FROM opportunity WHERE status = CLOSED_LOST GROUP BY industry")
    List<Object[]> findAllClosedLostOpportunitiesByIndustry();

    //A count of all OPEN Opportunities by industry
    @Query("SELECT industry, COUNT(id) FROM opportunity WHERE status = OPEN GROUP BY industry")
    List<Object[]> findAllOpenOpportunitiesByIndustry();

    //mean employeeCount
    @Query("SELECT AVG (employee_count) FROM account AS mean_employee_count")
    Optional<Account> findEmployeeCountAverage();

    //median employeeCount
    @Query("SELECT employee_count PERCENTILE_CONT(0.5) FROM account AS median_employee_count")
    Optional<Account> findEmployeeCountMedian();

    //maximum employeeCount
    @Query("SELECT MAX(employee_count)  FROM account AS max_employee_count")
    Optional<Account> findEmployeeCountMax();

    //minimum employeeCount
    @Query("SELECT MIN(employee_count)  FROM account AS min_employee_count")
    Optional<Account> findEmployeeCountMin();

    //mean quantity of products order
    @Query("SELECT AVG (product) FROM opportunity AS mean_product_quantity")
    Optional<Opportunity> findProductQuantityAverage();

    //median quantity of products order
    @Query("SELECT product PERCENTILE_CONT(0.5) FROM opportunity AS median_product_quantity")
    Optional<Opportunity> findProductQuantityMedian();

    //maximum quantity of products order
    @Query("SELECT MAX (product) FROM opportunity AS max_product_quantity")
    Optional<Opportunity> findProductQuantityMax();

    //minimum quantity of products order
    @Query("SELECT MIN (product) FROM opportunity AS min_product_quantity")
    Optional<Opportunity> findProductQuantityMin();

    //mean number of Opportunities associated with an Account
    @Query("SELECT AVG (opportunities) FROM account AS mean_opportunities_per_account")
    Optional<Account> findOpportunitiesPerAccountAverage();

    //median number of Opportunities associated with an Account
    @Query("SELECT opportunities PERCENTILE_CONT(0.5) FROM account AS median_opportunities_per_account")
    Optional<Account> findOpportunitiesPerAccountMedian();

    //maximum number of Opportunities associated with an Account
    @Query("SELECT MAX (opportunities) FROM account AS max_opportunities_per_account")
    Optional<Account> findOpportunitiesPerAccountMax();

    //minimum number of Opportunities associated with an Account
    @Query("SELECT MIN (opportunities) FROM account AS min_opportunities_per_account")
    Optional<Account> findOpportunitiesPerAccountMin();
}
