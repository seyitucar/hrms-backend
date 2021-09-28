package com.seyitucar.hrmsSpring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seyitucar.hrmsSpring.business.abstracts.SkillService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessDataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessResult;
import com.seyitucar.hrmsSpring.dataAccess.abstracts.SkillDao;
import com.seyitucar.hrmsSpring.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService {
	
	private SkillDao skillDao;

	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public Result add(Skill skill) {
		this.skillDao.save(skill);
		return new SuccessResult("Skill eklendi");
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		return new SuccessDataResult<List<Skill>>(this.skillDao.findAll());
	}

	@Override
	public DataResult<List<Skill>> getAllByEmployeeId(int employeeId) {
		return new SuccessDataResult<List<Skill>>(this.skillDao.findAllByEmployeeId(employeeId));
	}

	@Override
	public Result update(Skill skill) {
		Skill updSkill = this.skillDao.getById(skill.getId());
		updSkill.setProgrammingLanguage(skill.getProgrammingLanguage());
		updSkill.setTechnologyName(skill.getProgrammingLanguage());		
		this.skillDao.save(updSkill);
		return new SuccessResult("Yetenek bilgisi güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.skillDao.deleteById(id);
		return new SuccessResult("Yetenek bilgisi silindi");
	}

	@Override
	public DataResult<Skill> getById(int id) {
		return new SuccessDataResult<Skill>(this.skillDao.findById(id).orElse(null));
	}

}
