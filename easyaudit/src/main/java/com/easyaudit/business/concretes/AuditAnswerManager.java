package com.easyaudit.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyaudit.business.abstracts.AuditAnswerService;
import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.core.utilities.results.SuccessDataResult;
import com.easyaudit.core.utilities.results.SuccessResult;
import com.easyaudit.dataAccess.abstracts.AuditAnswerDao;
import com.easyaudit.entities.concretes.AuditAnswer;

@Service
public class AuditAnswerManager implements AuditAnswerService {
	
private AuditAnswerDao auditAnswerDao;
	
	@Autowired
	public AuditAnswerManager(AuditAnswerDao auditAnswerDao) {
		super();
		this.auditAnswerDao = auditAnswerDao;
	}

	@Override
	public Result add(AuditAnswer auditAnswer) {
		this.auditAnswerDao.save(auditAnswer);
		return new SuccessResult("Cevap eklendi");
	}

	@Override
	public Result update(AuditAnswer auditAnswer) {
		AuditAnswer updAuditAnswer = this.auditAnswerDao.getById(auditAnswer.getId());
		updAuditAnswer.setAnswerType(auditAnswer.getAnswerType());
		updAuditAnswer.setFinding(auditAnswer.getFinding());
		this.auditAnswerDao.save(updAuditAnswer);
		return new SuccessResult("Cevap güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.auditAnswerDao.deleteById(id);
		return new SuccessResult("Cevap silindi");
	}

	@Override
	public DataResult<AuditAnswer> getById(int id) {
		return new SuccessDataResult<AuditAnswer>(this.auditAnswerDao.findById(id).orElse(null));
	}

	@Override
	public DataResult<List<AuditAnswer>> getAll() {
		return new SuccessDataResult<List<AuditAnswer>>(this.auditAnswerDao.findAll());
	}

}
