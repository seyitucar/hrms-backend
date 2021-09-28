package com.seyitucar.hrmsSpring.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seyitucar.hrmsSpring.business.abstracts.EmployerUpdateConfirmService;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessResult;
import com.seyitucar.hrmsSpring.dataAccess.abstracts.EmployerDao;
import com.seyitucar.hrmsSpring.dataAccess.abstracts.EmployerUpdateConfirmDao;
import com.seyitucar.hrmsSpring.dataAccess.abstracts.EmployerUpdateDao;
import com.seyitucar.hrmsSpring.dataAccess.abstracts.SystemUserDao;
import com.seyitucar.hrmsSpring.entities.concretes.Employer;
import com.seyitucar.hrmsSpring.entities.concretes.EmployerUpdate;
import com.seyitucar.hrmsSpring.entities.concretes.EmployerUpdateConfirm;

@Service
public class EmployerUpdateConfirmManager implements EmployerUpdateConfirmService {

	private EmployerUpdateConfirmDao employerUpdateConfirmDao;
	private EmployerDao employerDao;
	private EmployerUpdateDao employerUpdateDao;
	
	@Autowired
	public EmployerUpdateConfirmManager(EmployerDao employerDao,EmployerUpdateDao employerUpdateDao, SystemUserDao systemUserDao, EmployerUpdateConfirmDao employerUpdateConfirmDao) {
		super();
		this.employerDao = employerDao;
		this.employerUpdateDao = employerUpdateDao;
		this.employerUpdateConfirmDao = employerUpdateConfirmDao;
		
	}

	@Override
	public Result verifyEmployerUpdate(EmployerUpdateConfirm employerUpdateConfirm) {
		
		EmployerUpdate employerUpdate = employerUpdateConfirm.getEmployerUpdate();
		Employer employer = employerUpdateConfirm.getEmployer();
		
		employer.setCompanyName(employerUpdate.getCompanyName());
		employer.setEmail(employerUpdate.getEmail());
		employer.setPhoneNumber(employerUpdate.getPhoneNumber());
		employer.setWebsite(employerUpdate.getWebsite());
		employer.setUpdated(false);

		employerUpdate.setVerified(true);
		employerUpdateConfirm.setConfirmed(true);
		
		this.employerDao.save(employer);
		this.employerUpdateDao.save(employerUpdate);
		this.employerUpdateConfirmDao.save(employerUpdateConfirm);		
		return new SuccessResult("İşveren bilgileri güncellendi");
	}

	@Override
	public Result rejectEmployerUpdate(EmployerUpdateConfirm employerUpdateConfirm) {
		
		EmployerUpdate employerUpdate = employerUpdateConfirm.getEmployerUpdate();
		Employer employer = employerUpdateConfirm.getEmployer();
		
		employer.setUpdated(false);
		employerUpdate.setVerified(true);
		employerUpdateConfirm.setConfirmed(false);
		
		this.employerDao.save(employer);
		this.employerUpdateDao.save(employerUpdate);
		this.employerUpdateConfirmDao.save(employerUpdateConfirm);
		
		return new SuccessResult("İşveren güncelleme talebi reddedildi!");
	}

}
