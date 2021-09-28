package com.seyitucar.hrmsSpring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seyitucar.hrmsSpring.business.abstracts.ResumeService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessDataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessResult;
import com.seyitucar.hrmsSpring.dataAccess.abstracts.ResumeDao;
import com.seyitucar.hrmsSpring.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao) {
		super();
		this.resumeDao = resumeDao;
	}

	@Override
	public DataResult<Resume> getByEmployeeId(int employeeId) {
		return new SuccessDataResult<Resume>(this.resumeDao.getByEmployeeId(employeeId));
	}

	@Override
	public Result add(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("CV eklendi");
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll());
	}

	@Override
	public Result update(Resume resume) {
		Resume updResume = this.resumeDao.getById(resume.getId());
		
		updResume.setImage(resume.getImage());
		return new SuccessResult("Cv güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.resumeDao.deleteById(id);
		return new SuccessResult("Cv silindi");
	}

	@Override
	public DataResult<Resume> getById(int id) {
		return new SuccessDataResult<Resume>(this.resumeDao.findById(id).orElse(null));
	}

}
