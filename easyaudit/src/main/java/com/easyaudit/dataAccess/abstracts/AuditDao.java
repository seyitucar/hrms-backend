package com.easyaudit.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyaudit.entities.concretes.Audit;

public interface AuditDao extends JpaRepository<Audit, Integer> {

}
