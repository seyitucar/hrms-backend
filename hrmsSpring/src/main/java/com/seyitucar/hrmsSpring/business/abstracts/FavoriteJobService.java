package com.seyitucar.hrmsSpring.business.abstracts;

import java.util.List;

import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.FavoriteJob;

public interface FavoriteJobService {
	
	Result add(FavoriteJob favoriteJob);
	Result remove(int favoriteJobId);
	DataResult<List<FavoriteJob>> getAll();
	DataResult<FavoriteJob> getById(int id);
	DataResult<List<FavoriteJob>> getAllByEmployeeId(int employeeId);
	DataResult<FavoriteJob> getByEmployeeIdAndJobAdvertisementId(int employeeId, int jobAdvertisementId);
}
