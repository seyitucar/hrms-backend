package com.seyitucar.hrmsSpring.business.abstracts;

import java.util.List;

import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.Resume;

public interface ResumeService {
	
	Result add(Resume resume);
	Result update(Resume resume);
	Result delete(int id);
	DataResult<Resume> getById(int id);
	DataResult<List<Resume>> getAll();
	DataResult<Resume> getByEmployeeId(int employeeId);
}
