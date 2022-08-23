package com.CRM.CRM.repositories;

import com.CRM.CRM.models.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {
}
