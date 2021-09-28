package com.easyaudit.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyaudit.business.abstracts.AuditService;
import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.core.utilities.results.SuccessDataResult;
import com.easyaudit.core.utilities.results.SuccessResult;
import com.easyaudit.dataAccess.abstracts.AuditDao;
import com.easyaudit.entities.concretes.Audit;

@Service
public class AuditManager implements AuditService {

	private AuditDao auditDao;
	
	@Autowired
	public AuditManager(AuditDao auditDao) {
		super();
		this.auditDao = auditDao;
	}

	@Override
	public Result add(Audit audit) {
		audit.setAuditReportNumber("Audit"+audit.getAuditDate());
		this.auditDao.save(audit);
		return new SuccessResult("Denetim eklendi");
	}

	@Override
	public Result update(Audit audit) {
		Audit updAudit = this.auditDao.getById(audit.getId());
		updAudit.setAuditDate(audit.getAuditDate());
		updAudit.setAuditor(audit.getAuditor());
		updAudit.setAuditType(audit.getAuditType());
		updAudit.setSupplier(audit.getSupplier());
		this.auditDao.save(updAudit);
		return new SuccessResult("Denetim güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.auditDao.deleteById(id);
		return new SuccessResult("Denetim silindi");
	}

	@Override
	public DataResult<Audit> getById(int id) {
		return new SuccessDataResult<Audit>(this.auditDao.findById(id).orElse(null));
	}

	@Override
	public DataResult<List<Audit>> getAll() {
		return new SuccessDataResult<List<Audit>>(this.auditDao.findAll());
	}

}
