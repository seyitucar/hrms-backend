package com.seyitucar.hrmsSpring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seyitucar.hrmsSpring.business.abstracts.JobAdvertisementService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessDataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessResult;
import com.seyitucar.hrmsSpring.dataAccess.abstracts.JobAdvertisementDao;
import com.seyitucar.hrmsSpring.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("İş ilanı eklendi");
	}
	
	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		
		JobAdvertisement updatedJobAdvertisement = this.jobAdvertisementDao.getById(jobAdvertisement.getId());
		
		updatedJobAdvertisement.setJobTitle(jobAdvertisement.getJobTitle());
		updatedJobAdvertisement.setJobDescription(jobAdvertisement.getJobDescription());
		updatedJobAdvertisement.setMinSalary(jobAdvertisement.getMinSalary());
		updatedJobAdvertisement.setMaxSalary(jobAdvertisement.getMaxSalary());
		updatedJobAdvertisement.setCity(jobAdvertisement.getCity());
		updatedJobAdvertisement.setNumberOfOpenPosition(jobAdvertisement.getNumberOfOpenPosition());
		updatedJobAdvertisement.setWorkingPlace(jobAdvertisement.getWorkingPlace());
		updatedJobAdvertisement.setWorkingType(jobAdvertisement.getWorkingType());
		updatedJobAdvertisement.setApplicationDeadline(jobAdvertisement.getApplicationDeadline());
		updatedJobAdvertisement.setClosingDate(jobAdvertisement.getClosingDate());
		this.jobAdvertisementDao.save(updatedJobAdvertisement);
		return new SuccessResult("İş ilanı güncellendi");
	}
	
	@Override
	public Result delete(int id) {
			this.jobAdvertisementDao.deleteById(id);
			return new SuccessResult("İş ilanı silindi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
	}
	
	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.findById(id).orElse(null));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>( this.jobAdvertisementDao.getByEmployerId(employerId));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrue());
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveFalse() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveFalse());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadline() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueOrderByApplicationDeadline());
	}


	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadlineDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueOrderByApplicationDeadlineDesc());
	}
	
	@Override
	public Result setStatus(int jobAdvertisementId, int employerId, boolean status) {	
		
		List<JobAdvertisement> jobAdvertisements = this.jobAdvertisementDao.getByEmployerId(employerId);
	
		for(JobAdvertisement jobAdvertisement:jobAdvertisements) {
			if(jobAdvertisementId == jobAdvertisement.getId()) {
				jobAdvertisement.setActive(status);
				this.jobAdvertisementDao.save(jobAdvertisement);
				return new SuccessResult("Statü değiştirildi");
			}
		}
		
		return null;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndCompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueAndEmployer_CompanyName(companyName));
	}

}
