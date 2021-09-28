package com.easyaudit.business.abstracts;

import java.util.List;

import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.entities.concretes.MainCategory;

public interface MainCategoryService {
	
	Result add(MainCategory mainCategory);
	Result update(MainCategory mainCategory);
	Result delete(int id);
	DataResult<MainCategory> getById(int id);
	DataResult<List<MainCategory>> getAll();

}
