package com.seyitucar.hrmsSpring.business.abstracts;

import java.util.List;

import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.SystemUser;

public interface SystemUserService {
	
	Result add(SystemUser systemUser);
	Result update(SystemUser systemUser);
	Result delete(int id);
	DataResult<SystemUser> getById(int id);
	DataResult<List<SystemUser>> getAll();
}
