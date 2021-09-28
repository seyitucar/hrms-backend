package com.seyitucar.hrmsSpring.business.abstracts;

import java.util.List;

import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.Employer;

public interface EmployerService {
	
	
	Result add(Employer employer);
	Result update(Employer employer);
	Result delete(int id);
	DataResult<Employer> getById(int id);
	DataResult<List<Employer>> getAll();
}
