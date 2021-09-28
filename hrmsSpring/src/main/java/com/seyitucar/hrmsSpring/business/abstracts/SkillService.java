package com.seyitucar.hrmsSpring.business.abstracts;

import java.util.List;

import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.Skill;

public interface SkillService {
	
	Result add(Skill skill);
	Result update(Skill skill);
	Result delete(int id);
	DataResult<Skill> getById(int id);
	DataResult<List<Skill>> getAll();
	DataResult<List<Skill>> getAllByEmployeeId(int employeeId);
}
