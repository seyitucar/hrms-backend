package com.easyaudit.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyaudit.business.abstracts.AuditTypeService;
import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.core.utilities.results.SuccessDataResult;
import com.easyaudit.core.utilities.results.SuccessResult;
import com.easyaudit.dataAccess.abstracts.AuditTypeDao;
import com.easyaudit.entities.concretes.AuditType;

@Service
public class AuditTypeManager implements AuditTypeService {

private AuditTypeDao auditTypeDao;
	
	@Autowired
	public AuditTypeManager(AuditTypeDao auditTypeDao) {
		super();
		this.auditTypeDao = auditTypeDao;
	}

	@Override
	public Result add(AuditType auditType) {
		this.auditTypeDao.save(auditType);
		return new SuccessResult("Denetim tipi eklendi");
	}

	@Override
	public Result update(AuditType auditType) {
		AuditType updAuditType = this.auditTypeDao.getById(auditType.getId());
		updAuditType.setAuditTypeName(auditType.getAuditTypeName());
		this.auditTypeDao.save(updAuditType);
		return new SuccessResult("Denetim tipi güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.auditTypeDao.deleteById(id);
		return new SuccessResult("Denetim tipi silindi");
	}

	@Override
	public DataResult<AuditType> getById(int id) {
		return new SuccessDataResult<AuditType>(this.auditTypeDao.findById(id).orElse(null));
	}

	@Override
	public DataResult<List<AuditType>> getAll() {
		return new SuccessDataResult<List<AuditType>>(this.auditTypeDao.findAll());
	}
}
