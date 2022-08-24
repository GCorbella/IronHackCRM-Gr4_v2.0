package com.CRM.CRM.repositories;

import com.CRM.CRM.models.Hook;
import com.CRM.CRM.models.Opportunity;
import com.CRM.CRM.models.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Integer> {


}
