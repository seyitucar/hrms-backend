package com.easyaudit.business.abstracts;

import java.util.List;

import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.entities.concretes.Audit;

public interface AuditService {
	
	Result add(Audit audit);
	Result update(Audit audit);
	Result delete(int id);
	DataResult<Audit> getById(int id);
	DataResult<List<Audit>> getAll();
}
