package com.seyitucar.hrmsSpring.business.abstracts;

import java.util.List;

import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	Result add(JobAdvertisement jobAdvertisement);
	Result update(JobAdvertisement jobAdvertisement);
	Result delete(int id);
	Result setStatus(int jobAdvertisementId, int employerId, boolean status);
	DataResult<JobAdvertisement> getById(int id);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndCompanyName(String companyName);
	DataResult<List<JobAdvertisement>> getByEmployerId(int employerId);
	DataResult<List<JobAdvertisement>> getByIsActiveTrue();
	DataResult<List<JobAdvertisement>> getByIsActiveFalse();
	DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadline();	
	DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadlineDesc();
}
