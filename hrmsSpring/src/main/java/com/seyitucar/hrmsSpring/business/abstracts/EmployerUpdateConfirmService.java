package com.seyitucar.hrmsSpring.business.abstracts;

import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.EmployerUpdateConfirm;

public interface EmployerUpdateConfirmService {
	
	Result verifyEmployerUpdate(EmployerUpdateConfirm employerUpdateConfirm);
	Result rejectEmployerUpdate(EmployerUpdateConfirm employerUpdateConfirm);
}
