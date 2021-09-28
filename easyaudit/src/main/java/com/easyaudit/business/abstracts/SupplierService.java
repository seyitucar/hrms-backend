package com.easyaudit.business.abstracts;

import java.util.List;

import com.easyaudit.core.utilities.results.DataResult;
import com.easyaudit.core.utilities.results.Result;
import com.easyaudit.entities.concretes.Supplier;

public interface SupplierService {
	Result add(Supplier supplier);
	Result update(Supplier supplier);
	Result delete(int id);
	DataResult<Supplier> getById(int id);
	DataResult<List<Supplier>> getAll();
}
