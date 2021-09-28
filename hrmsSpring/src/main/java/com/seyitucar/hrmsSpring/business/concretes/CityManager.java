package com.seyitucar.hrmsSpring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seyitucar.hrmsSpring.business.abstracts.CityService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessDataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessResult;
import com.seyitucar.hrmsSpring.dataAccess.abstracts.CityDao;
import com.seyitucar.hrmsSpring.entities.concretes.City;

@Service
public class CityManager implements CityService {
	
	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult("Şehir bilgisi eklendi");
	}
	
	@Override
	public Result update(City city) {
		City updatedCity = this.cityDao.getById(city.getId());
		
		updatedCity.setCityName(city.getCityName());
		this.cityDao.save(updatedCity);
		return new SuccessResult("Şehir bilgisi güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.cityDao.deleteById(id);
		return new SuccessResult("Şehir bilgisi silindi");
	}

	@Override
	public DataResult<City> getById(int id) {
		return new SuccessDataResult<City>(this.cityDao.findById(id).orElse(null));
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}

}
