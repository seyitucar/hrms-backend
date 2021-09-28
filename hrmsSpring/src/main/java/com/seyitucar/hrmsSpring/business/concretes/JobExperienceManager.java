package com.seyitucar.hrmsSpring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seyitucar.hrmsSpring.business.abstracts.JobExperienceService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessDataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessResult;
import com.seyitucar.hrmsSpring.dataAccess.abstracts.JobExperienceDao;
import com.seyitucar.hrmsSpring.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService {

	private JobExperienceDao jobExperienceDao;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public Result add(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("İş tecrübesi eklendi.");
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll());
	}

	@Override
	public DataResult<List<JobExperience>> findAllByEmployeeIdOrderByJobLeaveDateDesc(int employeeId) {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAllByEmployeeIdOrderByJobLeaveDateDesc(employeeId));
	}

	@Override
	public Result update(JobExperience jobExperience) {
		JobExperience updJobExperience = this.jobExperienceDao.getById(jobExperience.getId());
		
		updJobExperience.setPositionName(jobExperience.getPositionName());
		updJobExperience.setJobPlace(jobExperience.getJobPlace());
		updJobExperience.setJobStartDate(jobExperience.getJobStartDate());
		updJobExperience.setJobLeaveDate(jobExperience.getJobLeaveDate());
		
		this.jobExperienceDao.save(updJobExperience);
		return new SuccessResult("İş tecrübesi güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.jobExperienceDao.deleteById(id);
		return new SuccessResult("İş tecrübesi silindi");
	}

	@Override
	public DataResult<JobExperience> getById(int id) {
		return new SuccessDataResult<JobExperience>(this.jobExperienceDao.findById(id).orElse(null));
	}

}
