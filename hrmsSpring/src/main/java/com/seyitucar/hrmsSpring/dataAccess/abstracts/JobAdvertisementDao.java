package com.seyitucar.hrmsSpring.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seyitucar.hrmsSpring.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> getByEmployerId(int employerId);
	List<JobAdvertisement> getByIsActiveTrue();
	List<JobAdvertisement> getByIsActiveFalse(); 
	List<JobAdvertisement> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	List<JobAdvertisement> getByIsActiveTrueOrderByApplicationDeadline();	
	List<JobAdvertisement> getByIsActiveTrueOrderByApplicationDeadlineDesc();

}
