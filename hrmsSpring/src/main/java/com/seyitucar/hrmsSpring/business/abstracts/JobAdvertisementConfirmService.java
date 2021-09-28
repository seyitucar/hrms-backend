package com.seyitucar.hrmsSpring.business.abstracts;

import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.entities.concretes.JobAdvertisementConfirm;

public interface JobAdvertisementConfirmService {
	
	Result setActiveJobAdvertisement(JobAdvertisementConfirm jobAdvertisementConfirm);
	Result setPassiveJobAdvertisement(JobAdvertisementConfirm jobAdvertisementConfirm);

}
