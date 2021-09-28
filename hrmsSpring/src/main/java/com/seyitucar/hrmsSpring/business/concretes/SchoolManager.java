package com.seyitucar.hrmsSpring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seyitucar.hrmsSpring.business.abstracts.SchoolService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessDataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessResult;
import com.seyitucar.hrmsSpring.dataAccess.abstracts.SchoolDao;
import com.seyitucar.hrmsSpring.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Okul bilgisi eklendi");
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll());
	}

	@Override
	public DataResult<List<School>> findAllByEmployeeIdOrderBySchoolGraduationDateDesc(int employeeId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAllByEmployeeIdOrderBySchoolGraduationDateDesc(employeeId));
	}

	@Override
	public Result update(School school) {
		School updSchool = this.schoolDao.getById(school.getId());
		updSchool.setDepartmentName(school.getDepartmentName());
		updSchool.setSchoolName(school.getSchoolName());
		updSchool.setSchoolGraduationDate(school.getSchoolGraduationDate());
		updSchool.setSchoolStartDate(school.getSchoolStartDate());
		
		this.schoolDao.save(updSchool);
		return new SuccessResult("Eğitim bilgisi güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.schoolDao.deleteById(id);
		return new SuccessResult("Eğitim bilgisi silindi");
	}

	@Override
	public DataResult<School> getById(int id) {
		return new SuccessDataResult<School>(this.schoolDao.findById(id).orElse(null));
	}

}
