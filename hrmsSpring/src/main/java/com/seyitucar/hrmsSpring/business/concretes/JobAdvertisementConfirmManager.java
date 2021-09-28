package com.seyitucar.hrmsSpring.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seyitucar.hrmsSpring.business.abstracts.JobAdvertisementConfirmService;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessResult;
import com.seyitucar.hrmsSpring.dataAccess.abstracts.JobAdvertisementConfirmDao;
import com.seyitucar.hrmsSpring.dataAccess.abstracts.JobAdvertisementDao;
import com.seyitucar.hrmsSpring.entities.concretes.JobAdvertisement;
import com.seyitucar.hrmsSpring.entities.concretes.JobAdvertisementConfirm;

@Service
public class JobAdvertisementConfirmManager implements JobAdvertisementConfirmService {
	
	private JobAdvertisementConfirmDao jobAdvertisementConfirmDao;
	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementConfirmManager(JobAdvertisementConfirmDao jobAdvertisementConfirmDao,
			JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementConfirmDao = jobAdvertisementConfirmDao;
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result setActiveJobAdvertisement(JobAdvertisementConfirm jobAdvertisementConfirm) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(jobAdvertisementConfirm.getJobAdvertisement().getId());
		jobAdvertisement.setActive(true);
		this.jobAdvertisementDao.save(jobAdvertisement);
		
		jobAdvertisementConfirm.setConfirmed(true);
		this.jobAdvertisementConfirmDao.save(jobAdvertisementConfirm);
		
		return new SuccessResult("İlan aktifleştirildi.");
	}

	@Override
	public Result setPassiveJobAdvertisement(JobAdvertisementConfirm jobAdvertisementConfirm) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(jobAdvertisementConfirm.getJobAdvertisement().getId());
		jobAdvertisement.setActive(false);
		this.jobAdvertisementDao.save(jobAdvertisement);
		
		jobAdvertisementConfirm.setConfirmed(false);
		this.jobAdvertisementConfirmDao.save(jobAdvertisementConfirm);
		
		return new SuccessResult("İlan pasifleştirildi.");
	}

}
