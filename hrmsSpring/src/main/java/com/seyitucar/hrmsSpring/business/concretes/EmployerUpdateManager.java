package com.seyitucar.hrmsSpring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seyitucar.hrmsSpring.business.abstracts.EmployerUpdateService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.ErrorResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessDataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessResult;
import com.seyitucar.hrmsSpring.dataAccess.abstracts.EmployerDao;
import com.seyitucar.hrmsSpring.dataAccess.abstracts.EmployerUpdateDao;
import com.seyitucar.hrmsSpring.entities.concretes.Employer;
import com.seyitucar.hrmsSpring.entities.concretes.EmployerUpdate;

@Service
public class EmployerUpdateManager implements EmployerUpdateService {

	private EmployerUpdateDao employerUpdateDao;
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerUpdateManager(EmployerUpdateDao employerUpdateDao,EmployerDao employerDao) {
		super();
		this.employerUpdateDao = employerUpdateDao;
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<EmployerUpdate>> getAll() {
		return new SuccessDataResult<List<EmployerUpdate>>(this.employerUpdateDao.findAll());
	}

	@Override
	public DataResult<EmployerUpdate> getByEmployerIdAndIsVerifiedFalse(int employerId) {
		return new SuccessDataResult<EmployerUpdate>(this.employerUpdateDao.getByEmployerIdAndIsVerifiedFalse(employerId));
	}

	@Override
	public Result add(EmployerUpdate employerUpdate) {

		Employer employer = this.employerDao.getById(employerUpdate.getEmployerId());
		EmployerUpdate waitingUpdate = this.employerUpdateDao.getByEmployerIdAndIsVerifiedFalse(employerUpdate.getEmployerId());
		
		if (waitingUpdate != null) {
			return new ErrorResult("Halihazırda bir güncellemeniz devam etmektedir.");
		} else {
			employer.setUpdated(true);
			this.employerDao.save(employer);
					
			this.employerUpdateDao.save(employerUpdate);
			return new SuccessResult("Sistem yetkilisi onayı sonrası güncelleme gerçekleşecektir.");
		}
	}

}
