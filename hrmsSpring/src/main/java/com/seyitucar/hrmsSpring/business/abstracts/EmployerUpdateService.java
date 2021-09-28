package com.seyitucar.hrmsSpring.business.abstracts;

import java.util.List;

import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.EmployerUpdate;

public interface EmployerUpdateService {

	Result add(EmployerUpdate employerUpdate);
	DataResult<List<EmployerUpdate>> getAll();
	DataResult<EmployerUpdate> getByEmployerIdAndIsVerifiedFalse(int employerId);
	
}
