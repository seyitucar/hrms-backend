package com.easyaudit.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyaudit.entities.concretes.AuditType;

public interface AuditTypeDao extends JpaRepository<AuditType, Integer> {

}
