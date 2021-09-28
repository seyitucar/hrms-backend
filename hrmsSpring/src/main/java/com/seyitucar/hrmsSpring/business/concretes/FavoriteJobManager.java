package com.seyitucar.hrmsSpring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seyitucar.hrmsSpring.business.abstracts.FavoriteJobService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessDataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessResult;
import com.seyitucar.hrmsSpring.dataAccess.abstracts.FavoriteJobDao;
import com.seyitucar.hrmsSpring.entities.concretes.FavoriteJob;

@Service
public class FavoriteJobManager implements FavoriteJobService {
	
	private FavoriteJobDao favoriteJobDao;

	@Autowired
	public FavoriteJobManager(FavoriteJobDao favoriteJobDao) {
		super();
		this.favoriteJobDao = favoriteJobDao;
	}

	@Override
	public Result add(FavoriteJob favoriteJob) {
		
		FavoriteJob isFavorite = this.favoriteJobDao.getByEmployeeIdAndJobAdvertisementId(favoriteJob.getEmployee().getId(), favoriteJob.getJobAdvertisement().getId());

		if (isFavorite != null) {
			this.favoriteJobDao.deleteById(isFavorite.getId());
			return new SuccessResult("İlan favorilerinizden çıkarıldı!");
		} else {
			this.favoriteJobDao.save(favoriteJob);
			return new SuccessResult("İlan favorilerinize eklendi!");
		}
	}

	@Override
	public Result remove(int favoriteJobId) {
		this.favoriteJobDao.deleteById(favoriteJobId);
		return new SuccessResult("İlan favorilerinizden çıkarıldı!");
	}

	@Override
	public DataResult<List<FavoriteJob>> getAll() {
		return new SuccessDataResult<List<FavoriteJob>>(this.favoriteJobDao.findAll());
	}

	@Override
	public DataResult<FavoriteJob> getById(int id) {
		return new SuccessDataResult<FavoriteJob>(this.favoriteJobDao.getById(id));
	}

	@Override
	public DataResult<List<FavoriteJob>> getAllByEmployeeId(int employeeId) {
		return new SuccessDataResult<List<FavoriteJob>>(this.favoriteJobDao.getAllByEmployeeId(employeeId));
	}

	@Override
	public DataResult<FavoriteJob> getByEmployeeIdAndJobAdvertisementId(int employeeId, int jobAdvertisementId) {
		return new SuccessDataResult<FavoriteJob>(this.favoriteJobDao.getByEmployeeIdAndJobAdvertisementId(employeeId, jobAdvertisementId));
	}

}
