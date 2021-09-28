package com.seyitucar.hrmsSpring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seyitucar.hrmsSpring.business.BusinessRules;
import com.seyitucar.hrmsSpring.business.abstracts.SystemUserService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.ErrorResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessDataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessResult;
import com.seyitucar.hrmsSpring.dataAccess.abstracts.SystemUserDao;
import com.seyitucar.hrmsSpring.entities.concretes.SystemUser;

@Service
public class SystemUserManager implements SystemUserService {
	
	private SystemUserDao systemUserDao;
	
	@Autowired
	public SystemUserManager(SystemUserDao systemUserDao) {
		super();
		this.systemUserDao = systemUserDao;
	}

	@Override
	public DataResult<List<SystemUser>> getAll() {
		return new SuccessDataResult<List<SystemUser>>(this.systemUserDao.findAll());
	}

	@Override
	public Result add(SystemUser systemUser) {
		Result result = BusinessRules.run(existEmail(systemUser.getEmail()));

		if (result.isSuccess()) {
			this.systemUserDao.save(systemUser);
			return new SuccessResult("Sistem kullanıcısı Eklendi");
		}
		return result;
	}

	private Result existEmail(String email) {
		if (this.systemUserDao.findByEmailEquals(email) != null) {
			return new ErrorResult("Email adresi ile daha önce kayıt oluşturulmuştur");
		}
		return new SuccessResult();
	}

	@Override
	public Result update(SystemUser systemUser) {
		SystemUser updSystemUser = this.systemUserDao.getById(systemUser.getId());
		
		updSystemUser.setFirstName(systemUser.getFirstName());
		updSystemUser.setLastName(systemUser.getLastName());
		updSystemUser.setEmail(systemUser.getEmail());
		updSystemUser.setPassword(systemUser.getPassword());
		
		Result result = BusinessRules.run(existEmail(systemUser.getEmail()));
		
		if (result.isSuccess()) {
			this.systemUserDao.save(updSystemUser);
			return new SuccessResult("Sistem kullanıcısı Güncellendi");
		}
		return result;
	}

	@Override
	public Result delete(int id) {
		this.systemUserDao.deleteById(id);
		return new SuccessResult("Sistem kullanıcısı silindi");
	}

	@Override
	public DataResult<SystemUser> getById(int id) {
		return new SuccessDataResult<SystemUser>(this.systemUserDao.findById(id).orElse(null)) ;
	}

}
