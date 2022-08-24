package com.CRM.CRM.repositories;

import com.CRM.CRM.models.Hook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HookRepository extends JpaRepository<Hook, Integer> {


}
