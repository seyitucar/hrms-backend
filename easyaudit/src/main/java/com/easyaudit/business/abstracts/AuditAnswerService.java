package com.easyaudit.business.abstracts;

import java.util.List;

import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.entities.concretes.AuditAnswer;

public interface AuditAnswerService {
	Result add(AuditAnswer auditAnswer);
	Result update(AuditAnswer auditAnswer);
	Result delete(int id);
	DataResult<AuditAnswer> getById(int id);
	DataResult<List<AuditAnswer>> getAll();
}
