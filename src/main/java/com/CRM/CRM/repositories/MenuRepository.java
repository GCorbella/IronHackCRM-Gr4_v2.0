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

    List<Hook> findHookBySalesRep (SalesRep salesRep);

    List<Opportunity> findAllOpportunitiesBySalesRep(SalesRep salesRep);

    @Query("SELECT * FROM opportunity WHERE status=CLOSED_WON GROUP BY sales_rep")
    List<Object[]> findAllClosedWonOpportunitiesBySalesRep();

    @Query("SELECT * FROM opportunity WHERE status=CLOSED_LOST GROUP BY sales_rep")
    List<Object[]> findAllClosedLostOpportunitiesBySalesRep();

    @Query("SELECT * FROM opportunity WHERE status=OPEN GROUP BY sales_rep")
    List<Object[]> findAllOpenOpportunitiesBySalesRep();

    List<Opportunity> findAllOpportunitiesByProduct(Product product);

    @Query("SELECT * FROM opportunity WHERE status=CLOSED_WON GROUP BY product")
    List<Object[]> findAllClosedWonOpportunitiesByProduct();

    @Query("SELECT * FROM opportunity WHERE status=CLOSED_LOST GROUP BY product")
    List<Object[]> findAllClosedLostOpportunitiesByProduct();

    @Query("SELECT * FROM opportunity WHERE status=OPEN GROUP BY product")
    List<Object[]> findAllOpenOpportunitiesByProduct();

    List<Opportunity> findAllOpportunitiesByCountry(String country);

    @Query("SELECT * FROM opportunity WHERE status=CLOSED_WON GROUP BY account.country")
    List<Object[]> findAllClosedWonOpportunitiesByCountry();

    @Query("SELECT * FROM opportunity WHERE status=CLOSED_LOST GROUP BY account.country")
    List<Object[]> findAllClosedLostOpportunitiesByCountry();

    @Query("SELECT * FROM opportunity WHERE status=OPEN GROUP BY account.country")
    List<Object[]> findAllOpenOpportunitiesByCountry();

    List<Opportunity> findAllOpportunitiesByCity(String city);

    @Query("SELECT * FROM opportunity WHERE status=CLOSED_WON GROUP BY account.city")
    List<Object[]> findAllClosedWonOpportunitiesByCity();

    @Query("SELECT * FROM opportunity WHERE status=CLOSED_LOST GROUP BY account.city")
    List<Object[]> findAllClosedLostOpportunitiesByCity();

    @Query("SELECT * FROM opportunity WHERE status=OPEN GROUP BY account.city")
    List<Object[]> findAllOpenOpportunitiesByCity();

    List<Opportunity> findAllOpportunitiesByIndustry(Industry industry);

    @Query("SELECT * FROM opportunity WHERE status=CLOSED_WON GROUP BY industry")
    List<Object[]> findAllClosedWonOpportunitiesByIndustry();

    @Query("SELECT * FROM opportunity WHERE status=CLOSED_LOST GROUP BY industry")
    List<Object[]> findAllClosedLostOpportunitiesByIndustry();

    @Query("SELECT * FROM opportunity WHERE status=OPEN GROUP BY industry")
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
