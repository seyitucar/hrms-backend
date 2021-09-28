package com.easyaudit.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyaudit.business.abstracts.DepartmentService;
import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.core.utilities.results.SuccessDataResult;
import com.easyaudit.core.utilities.results.SuccessResult;
import com.easyaudit.dataAccess.abstracts.DepartmentDao;
import com.easyaudit.entities.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService {

private DepartmentDao departmentDao;
	
	@Autowired
	public DepartmentManager(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}

	@Override
	public Result add(Department department) {
		this.departmentDao.save(department);
		return new SuccessResult("Departman bilgisi eklendi");
	}

	@Override
	public Result update(Department department) {
		Department updDepartment = this.departmentDao.getById(department.getId());
		updDepartment.setDepartmentName(department.getDepartmentName());
		this.departmentDao.save(updDepartment);
		return new SuccessResult("Departman bilgisi güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.departmentDao.deleteById(id);
		return new SuccessResult("Departman bilgisi silindi");
	}

	@Override
	public DataResult<Department> getById(int id) {
		return new SuccessDataResult<Department>(this.departmentDao.findById(id).orElse(null));
	}

	@Override
	public DataResult<List<Department>> getAll() {
		return new SuccessDataResult<List<Department>>(this.departmentDao.findAll());
	}
}
