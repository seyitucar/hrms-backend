package com.easyaudit.business.abstracts;

import java.util.List;

import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.entities.concretes.SubCategory;

public interface SubCategoryService {

	Result add(SubCategory subCategory);
	Result update(SubCategory subCategory);
	Result delete(int id);
	DataResult<SubCategory> getById(int id);
	DataResult<List<SubCategory>> getAll();
}
