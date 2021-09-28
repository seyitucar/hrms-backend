package com.easyaudit.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyaudit.entities.concretes.AuditAnswer;

public interface AuditAnswerDao extends JpaRepository<AuditAnswer, Integer> {

}
