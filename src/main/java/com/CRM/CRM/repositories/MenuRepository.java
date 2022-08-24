package com.CRM.CRM.repositories;

import com.CRM.CRM.models.Hook;
import com.CRM.CRM.models.Opportunity;
import com.CRM.CRM.models.SalesRep;
import com.CRM.CRM.models.enums.Industry;
import com.CRM.CRM.models.enums.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

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


}
