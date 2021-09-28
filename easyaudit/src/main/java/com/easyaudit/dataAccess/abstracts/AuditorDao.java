package com.easyaudit.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyaudit.entities.concretes.Auditor;

public interface AuditorDao extends JpaRepository<Auditor, Integer> {

}
