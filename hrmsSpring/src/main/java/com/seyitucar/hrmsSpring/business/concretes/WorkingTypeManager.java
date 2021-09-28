package com.seyitucar.hrmsSpring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seyitucar.hrmsSpring.business.abstracts.WorkingTypeService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessDataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessResult;
import com.seyitucar.hrmsSpring.dataAccess.abstracts.WorkingTypeDao;
import com.seyitucar.hrmsSpring.entities.concretes.WorkingType;

@Service
public class WorkingTypeManager implements WorkingTypeService {

	private WorkingTypeDao workingTypeDao;
	
	@Autowired
	public WorkingTypeManager(WorkingTypeDao workingTypeDao) {
		super();
		this.workingTypeDao = workingTypeDao;
	}

	@Override
	public Result add(WorkingType workingType) {
		this.workingTypeDao.save(workingType);
		return new SuccessResult("Çalışma tipi bilgisi eklendi");
	}

	@Override
	public DataResult<List<WorkingType>> getAll() {
		return new SuccessDataResult<List<WorkingType>>(this.workingTypeDao.findAll());
	}

	@Override
	public Result update(WorkingType workingType) {
		WorkingType updType = this.workingTypeDao.getById(workingType.getId());
		
		updType.setWorkingTypeName(workingType.getWorkingTypeName());
		this.workingTypeDao.save(updType);
		return new SuccessResult("Çalışma tipi bilgisi güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.workingTypeDao.deleteById(id);
		return new SuccessResult("Çalışma tipi bilgisi silindi");
	}

	@Override
	public DataResult<WorkingType> getById(int id) {
		return new SuccessDataResult<WorkingType>(this.workingTypeDao.findById(id).orElse(null));
	}

}
