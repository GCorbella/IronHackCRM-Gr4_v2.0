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

    @Query("SELECT sales_rep.name, COUNT(opportunity.id) FROM opportunity JOIN sales_rep ON opportunity.sales_rep_id = sales_rep.id WHERE opportunity.status = CLOSED_WON GROUP BY sales_rep_id")
    List<Object[]> findAllClosedWonOpportunitiesBySalesRep();

    @Query("SELECT sales_rep.name, COUNT(opportunity.id) FROM opportunity JOIN sales_rep ON opportunity.sales_rep_id = sales_rep.id WHERE opportunity.status = CLOSED_LOST GROUP BY sales_rep_id")
    List<Object[]> findAllClosedLostOpportunitiesBySalesRep();

    @Query("SELECT sales_rep.name, COUNT(opportunity.id) FROM opportunity JOIN sales_rep ON opportunity.sales_rep_id = sales_rep.id WHERE opportunity.status = OPEN  GROUP BY sales_rep_id")
    List<Object[]> findAllOpenOpportunitiesBySalesRep();

    @Query("SELECT product, COUNT(id) FROM opportunity GROUP BY product")
    List<Object[]> findAllOpportunitiesByProduct();

    @Query("SELECT product, COUNT(id) FROM opportunity WHERE status=CLOSED_WON GROUP BY product")
    List<Object[]> findAllClosedWonOpportunitiesByProduct();

    @Query("SELECT product, COUNT(id) FROM opportunity WHERE status=CLOSED_LOST GROUP BY product")
    List<Object[]> findAllClosedLostOpportunitiesByProduct();

    @Query("SELECT product, COUNT(id) FROM opportunity WHERE status=OPEN GROUP BY product")
    List<Object[]> findAllOpenOpportunitiesByProduct();

    @Query("SELECT account.country, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account GROUP BY account.country")
    List<Object[]> findAllOpportunitiesByCountry();

    @Query("SELECT account.country, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account WHERE opportunity.status = CLOSED_WON GROUP BY account.country")
    List<Object[]> findAllClosedWonOpportunitiesByCountry();

    @Query("SELECT account.country, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account WHERE opportunity.status = CLOSED_LOST GROUP BY account.country")
    List<Object[]> findAllClosedLostOpportunitiesByCountry();

    @Query("SELECT account.country, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account WHERE opportunity.status = OPEN GROUP BY account.country")
    List<Object[]> findAllOpenOpportunitiesByCountry();

    @Query("SELECT account.city, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account GROUP BY account.city")
    List<Object[]> findAllOpportunitiesByCity();

    @Query("SELECT account.city, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account WHERE opportunity.status = CLOSED_WON GROUP BY account.city")
    List<Object[]> findAllClosedWonOpportunitiesByCity();

    @Query("SELECT account.city, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account WHERE opportunity.status = CLOSED_LOST GROUP BY account.city")
    List<Object[]> findAllClosedLostOpportunitiesByCity();

    @Query("SELECT account.city, COUNT(opportunity.id) FROM opportunity JOIN account ON opportunity.account = account WHERE opportunity.status = OPEN GROUP BY account.city")
    List<Object[]> findAllOpenOpportunitiesByCity();

    @Query("SELECT industry, COUNT(id) FROM opportunity GROUP BY industry")
    List<Object[]> findAllOpportunitiesByIndustry();

    @Query("SELECT industry, COUNT(id) FROM opportunity WHERE status = CLOSED_WON GROUP BY industry")
    List<Object[]> findAllClosedWonOpportunitiesByIndustry();

    @Query("SELECT industry, COUNT(id) FROM opportunity WHERE status = CLOSED_LOST GROUP BY industry")
    List<Object[]> findAllClosedLostOpportunitiesByIndustry();

    @Query("SELECT industry, COUNT(id) FROM opportunity WHERE status = OPEN GROUP BY industry")
    List<Object[]> findAllOpenOpportunitiesByIndustry();

    @Query("SELECT AVG (employee_count) FROM account AS mean_employee_count")
    Optional<Account> findEmployeeCountAverage();

    @Query("SELECT employee_count PERCENTILE_CONT(0.5) FROM account AS median_employee_count")
    Optional<Account> findEmployeeCountMedian();

    @Query("SELECT MAX(employee_count)  FROM account AS max_employee_count")
    Optional<Account> findEmployeeCountMax();

    @Query("SELECT MIN(employee_count)  FROM account AS min_employee_count")
    Optional<Account> findEmployeeCountMin();

    @Query("SELECT AVG (product) FROM opportunity AS mean_product_quantity")
    Optional<Opportunity> findProductQuantityAverage();

    @Query("SELECT product PERCENTILE_CONT(0.5) FROM opportunity AS median_product_quantity")
    Optional<Opportunity> findProductQuantityMedian();

    @Query("SELECT MAX (product) FROM opportunity AS max_product_quantity")
    Optional<Opportunity> findProductQuantityMax();

    @Query("SELECT MIN (product) FROM opportunity AS min_product_quantity")
    Optional<Opportunity> findProductQuantityMin();

    @Query("SELECT AVG (opportunities) FROM account AS mean_opportunities_per_account")
    Optional<Account> findOpportunitiesPerAccountAverage();

    @Query("SELECT opportunities PERCENTILE_CONT(0.5) FROM account AS median_opportunities_per_account")
    Optional<Account> findOpportunitiesPerAccountMedian();

    @Query("SELECT MAX (opportunities) FROM account AS max_opportunities_per_account")
    Optional<Account> findOpportunitiesPerAccountMax();

    @Query("SELECT MIN (opportunities) FROM account AS min_opportunities_per_account")
    Optional<Account> findOpportunitiesPerAccountMin();
}
