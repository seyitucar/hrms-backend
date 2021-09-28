package com.easyaudit.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyaudit.business.abstracts.AuditorService;
import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.core.utilities.results.SuccessDataResult;
import com.easyaudit.core.utilities.results.SuccessResult;
import com.easyaudit.dataAccess.abstracts.AuditorDao;
import com.easyaudit.entities.concretes.Auditor;

@Service
public class AuditorManager implements AuditorService {

	private AuditorDao auditorDao;
	
	@Autowired
	public AuditorManager(AuditorDao auditorDao) {
		super();
		this.auditorDao = auditorDao;
	}

	@Override
	public Result add(Auditor auditor) {
		this.auditorDao.save(auditor);
		return new SuccessResult("Denetçi eklendi");
	}

	@Override
	public Result update(Auditor auditor) {
		Auditor updAuditor = this.auditorDao.getById(auditor.getId());
		updAuditor.setFirstName(auditor.getFirstName());
		updAuditor.setLastName(auditor.getLastName());
		updAuditor.setDepartment(auditor.getDepartment());
		this.auditorDao.save(updAuditor);
		return new SuccessResult("Denetçi güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.auditorDao.deleteById(id);
		return new SuccessResult("Denetçi silindi");
	}

	@Override
	public DataResult<Auditor> getById(int id) {
		return new SuccessDataResult<Auditor>(this.auditorDao.findById(id).orElse(null));
	}

	@Override
	public DataResult<List<Auditor>> getAll() {
		return new SuccessDataResult<List<Auditor>>(this.auditorDao.findAll());
	}
}
