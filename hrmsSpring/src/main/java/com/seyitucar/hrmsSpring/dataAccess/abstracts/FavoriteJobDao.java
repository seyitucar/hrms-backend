package com.seyitucar.hrmsSpring.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.seyitucar.hrmsSpring.entities.concretes.FavoriteJob; 

public interface FavoriteJobDao extends JpaRepository<FavoriteJob, Integer> {
	List<FavoriteJob> getAllByEmployeeId(int employeeId);
	FavoriteJob getByEmployeeIdAndJobAdvertisementId(int employeeId, int jobAdvertisementId);
}
