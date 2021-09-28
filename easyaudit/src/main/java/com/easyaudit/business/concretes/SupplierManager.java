package com.easyaudit.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyaudit.business.abstracts.SupplierService;
import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.core.utilities.results.SuccessDataResult;
import com.easyaudit.core.utilities.results.SuccessResult;
import com.easyaudit.dataAccess.abstracts.SupplierDao;
import com.easyaudit.entities.concretes.Supplier;

@Service
public class SupplierManager implements SupplierService {
	
private SupplierDao supplierDao;
	
	@Autowired
	public SupplierManager(SupplierDao supplierDao) {
		super();
		this.supplierDao = supplierDao;
	}

	@Override
	public Result add(Supplier supplier) {
		this.supplierDao.save(supplier);
		return new SuccessResult("Üretici eklendi");
	}

	@Override
	public Result update(Supplier supplier) {
		Supplier updSupplier = this.supplierDao.getById(supplier.getId());
		updSupplier.setSupplierName(supplier.getSupplierName());
		this.supplierDao.save(updSupplier);
		return new SuccessResult("Üretici güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.supplierDao.deleteById(id);
		return new SuccessResult("Üretici silindi");
	}

	@Override
	public DataResult<Supplier> getById(int id) {
		return new SuccessDataResult<Supplier>(this.supplierDao.findById(id).orElse(null));
	}

	@Override
	public DataResult<List<Supplier>> getAll() {
		return new SuccessDataResult<List<Supplier>>(this.supplierDao.findAll());
	}

}
