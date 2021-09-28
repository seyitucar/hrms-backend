package com.easyaudit.business.abstracts;

import java.util.List;

import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.entities.concretes.Auditor;

public interface AuditorService {
	Result add(Auditor auditor);
	Result update(Auditor auditor);
	Result delete(int id);
	DataResult<Auditor> getById(int id);
	DataResult<List<Auditor>> getAll();
}
