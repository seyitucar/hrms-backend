package com.seyitucar.hrmsSpring.business.abstracts;

import java.util.List;

import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.EmployeeSocialMedia;


public interface EmployeeSocialMediaService {

	Result add(EmployeeSocialMedia employeeSocialMedia);
	Result update(EmployeeSocialMedia employeeSocialMedia);
	Result delete(int id);
	DataResult<EmployeeSocialMedia> getById(int id);
	DataResult<List<EmployeeSocialMedia>> getAll();
	DataResult<List<EmployeeSocialMedia>> getAllByEmployeeId(int employeeId);
}
