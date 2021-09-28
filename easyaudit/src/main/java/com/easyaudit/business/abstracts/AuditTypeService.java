package com.easyaudit.business.abstracts;

import java.util.List;

import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.entities.concretes.AuditType;

public interface AuditTypeService {
	Result add(AuditType auditType);
	Result update(AuditType auditType);
	Result delete(int id);
	DataResult<AuditType> getById(int id);
	DataResult<List<AuditType>> getAll();

}
