package com.seyitucar.hrmsSpring.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seyitucar.hrmsSpring.entities.concretes.SocialMedia;

public interface SocialMediaDao extends JpaRepository<SocialMedia, Integer> {
	
}
