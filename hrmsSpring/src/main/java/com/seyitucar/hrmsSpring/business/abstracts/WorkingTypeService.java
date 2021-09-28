package com.seyitucar.hrmsSpring.business.abstracts;

import java.util.List;

import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.WorkingType;

public interface WorkingTypeService {

	Result add(WorkingType workingType);
	Result update(WorkingType workingType);
	Result delete(int id);
	DataResult<WorkingType> getById(int id);
	DataResult<List<WorkingType>> getAll(); 
}
