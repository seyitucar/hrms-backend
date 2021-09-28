package com.seyitucar.hrmsSpring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seyitucar.hrmsSpring.business.abstracts.CoverLetterService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessDataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessResult;
import com.seyitucar.hrmsSpring.dataAccess.abstracts.CoverLetterDao;
import com.seyitucar.hrmsSpring.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService {
	
	private CoverLetterDao coverLetterDao;

	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Ön yazı eklendi");
	}
	
	@Override
	public Result update(CoverLetter coverLetter) {
		CoverLetter updatedCoverLetter = this.coverLetterDao.getById(coverLetter.getId());
		updatedCoverLetter.setDescription(coverLetter.getDescription());
		this.coverLetterDao.save(updatedCoverLetter);
		return new SuccessResult("Ön yazı güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.coverLetterDao.deleteById(id);
		return new SuccessResult("Ön yazı silindi");
	}

	@Override
	public DataResult<CoverLetter> getById(int id) {
		return new SuccessDataResult<CoverLetter>(this.coverLetterDao.findById(id).orElse(null));
	}

	@Override
	public DataResult<List<CoverLetter>> getAll() {
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.findAll());
	}

	@Override
	public DataResult<List<CoverLetter>> getAllByEmployeeId(int employeeId) {
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.getAllByEmployeeId(employeeId));
	}

}
