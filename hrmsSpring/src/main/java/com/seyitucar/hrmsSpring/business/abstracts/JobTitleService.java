package com.seyitucar.hrmsSpring.business.abstracts;

import java.util.List;

import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.JobTitle;

public interface JobTitleService {
	
	Result add(JobTitle jobTitle);
	Result update(JobTitle jobTitle);
	Result delete(int id);
	DataResult<JobTitle> getById(int id);
	DataResult<List<JobTitle>> getAll();
}
