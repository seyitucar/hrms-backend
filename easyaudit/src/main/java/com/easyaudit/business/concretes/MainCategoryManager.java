package com.easyaudit.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyaudit.business.abstracts.MainCategoryService;
import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.core.utilities.results.SuccessDataResult;
import com.easyaudit.core.utilities.results.SuccessResult;
import com.easyaudit.dataAccess.abstracts.MainCategoryDao;
import com.easyaudit.entities.concretes.MainCategory;

@Service
public class MainCategoryManager implements MainCategoryService {
	
	private MainCategoryDao mainCategoryDao;

	@Autowired
	public MainCategoryManager(MainCategoryDao mainCategoryDao) {
		super();
		this.mainCategoryDao = mainCategoryDao;
	}

	@Override
	public Result add(MainCategory mainCategory) {
		this.mainCategoryDao.save(mainCategory);
		return new SuccessResult("Ana kategori bilgisi eklendi"); 
	}

	@Override
	public Result update(MainCategory mainCategory) {
		MainCategory updMainCategory = this.mainCategoryDao.getById(mainCategory.getId());	
		updMainCategory.setMainCategoryName(mainCategory.getMainCategoryName());
		this.mainCategoryDao.save(updMainCategory);
		return new SuccessResult("Ana kategori bilgisi güncellendi"); 
	}

	@Override
	public Result delete(int id) {
		this.mainCategoryDao.deleteById(id);
		return new SuccessResult("Ana kategori bilgisi silindi");
	}

	@Override
	public DataResult<MainCategory> getById(int id) {
		return new SuccessDataResult<MainCategory>(this.mainCategoryDao.findById(id).orElse(null)) ;
	}

	@Override
	public DataResult<List<MainCategory>> getAll() {
		return new SuccessDataResult<List<MainCategory>>(this.mainCategoryDao.findAll());
	}

}
