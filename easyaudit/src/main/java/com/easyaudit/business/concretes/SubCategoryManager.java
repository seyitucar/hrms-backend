package com.easyaudit.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyaudit.business.abstracts.SubCategoryService;
import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.core.utilities.results.SuccessDataResult;
import com.easyaudit.core.utilities.results.SuccessResult;
import com.easyaudit.dataAccess.abstracts.SubCategoryDao;
import com.easyaudit.entities.concretes.SubCategory;

@Service
public class SubCategoryManager implements SubCategoryService {
	
	private SubCategoryDao subCategoryDao;

	@Autowired
	public SubCategoryManager(SubCategoryDao subCategoryDao) {
		super();
		this.subCategoryDao = subCategoryDao;
	}

	@Override
	public Result add(SubCategory subCategory) {
		this.subCategoryDao.save(subCategory);
		return new SuccessResult("Alt kategori bilgisi eklendi");
	}

	@Override
	public Result update(SubCategory subCategory) {
		SubCategory updSubCategory = this.subCategoryDao.getById(subCategory.getId());
		updSubCategory.setSubCategoryName(subCategory.getSubCategoryName());
		this.subCategoryDao.save(subCategory);
		return new SuccessResult("Alt kategori bilgisi güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.subCategoryDao.deleteById(id);
		return new SuccessResult("Alt kategori bilgisi silindi");
	}

	@Override
	public DataResult<SubCategory> getById(int id) {
		return new SuccessDataResult<SubCategory>(this.subCategoryDao.findById(id).orElse(null));
	}

	@Override
	public DataResult<List<SubCategory>> getAll() {
		return new SuccessDataResult<List<SubCategory>>(this.subCategoryDao.findAll());
	}

}
