package com.seyitucar.hrmsSpring.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seyitucar.hrmsSpring.entities.concretes.JobAdvertisementConfirm;

public interface JobAdvertisementConfirmDao extends JpaRepository<JobAdvertisementConfirm, Integer> {


}
