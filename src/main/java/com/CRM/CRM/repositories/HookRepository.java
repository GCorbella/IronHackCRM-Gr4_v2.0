package com.CRM.CRM.repositories;

import com.CRM.CRM.models.Hook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HookRepository extends JpaRepository<Hook, Integer> {

    //A count of Leads by SalesRep
    @Query(value = "SELECT sales_rep.name, COUNT(hook.id) FROM hook JOIN sales_rep ON hook.sales_rep_id = sales_rep.id GROUP BY sales_rep_id",nativeQuery = true)
    List<Object[]> findHooksBySalesRep ();
}
