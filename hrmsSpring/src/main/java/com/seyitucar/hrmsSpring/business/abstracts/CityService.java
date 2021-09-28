package com.seyitucar.hrmsSpring.business.abstracts;

import java.util.List;

import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.City;

public interface CityService {
	
	Result add(City city);
	Result update(City city);
	Result delete(int id);
	DataResult<List<City>> getAll();
	DataResult<City> getById(int id);
}
