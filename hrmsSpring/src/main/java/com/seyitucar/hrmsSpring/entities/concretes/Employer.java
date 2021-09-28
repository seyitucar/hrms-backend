package com.seyitucar.hrmsSpring.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.seyitucar.hrmsSpring.core.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Employer extends User{
	
	@Column(name="company_name")
	@NotBlank
	@NotNull
	private String companyName;
	
	@Column(name="website")
	@NotBlank
	@NotNull
	private String website;
	
	@Column(name="phone_number")
	@NotBlank
	@NotNull
	private String phoneNumber;
	
	@Column(name="is_updated")
	private boolean isUpdated = false;
	
	@JsonIgnore 
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
	private List<EmployerUpdateConfirm> employerUpdateConfirm;
}
