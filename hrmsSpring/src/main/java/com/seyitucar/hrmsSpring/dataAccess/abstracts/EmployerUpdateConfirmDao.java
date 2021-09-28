package com.seyitucar.hrmsSpring.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seyitucar.hrmsSpring.entities.concretes.EmployerUpdateConfirm;

public interface EmployerUpdateConfirmDao extends JpaRepository<EmployerUpdateConfirm, Integer> {

}
