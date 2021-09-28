package com.easyaudit.business.abstracts;

import java.util.List;

import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.entities.concretes.Department;

public interface DepartmentService {
	Result add(Department department);
	Result update(Department department);
	Result delete(int id);
	DataResult<Department> getById(int id);
	DataResult<List<Department>> getAll();

}
