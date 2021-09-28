package com.seyitucar.hrmsSpring.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisement_confirms")
@PrimaryKeyJoinColumn(name = "id")
@EqualsAndHashCode(callSuper = false)
public class JobAdvertisementConfirm extends SystemUserConfirm {
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "job_advertisement_id")
	private JobAdvertisement jobAdvertisement;

}
