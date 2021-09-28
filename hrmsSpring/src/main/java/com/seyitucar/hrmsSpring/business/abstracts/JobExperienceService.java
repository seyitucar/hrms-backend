package com.seyitucar.hrmsSpring.business.abstracts;

import java.util.List;

import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.JobExperience;

public interface JobExperienceService {

	Result add(JobExperience jobExperience);
	Result update(JobExperience jobExperience);
	Result delete(int id);
	DataResult<JobExperience> getById(int id);
	DataResult<List<JobExperience>> getAll();
	DataResult<List<JobExperience>> findAllByEmployeeIdOrderByJobLeaveDateDesc(int employeeId);
}
