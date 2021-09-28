package com.seyitucar.hrmsSpring.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employer_updates")
public class EmployerUpdate {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	
	@Column(name="company_name")
	@NotBlank
	@NotNull
	private String companyName;
	
	@Column(name="email")
	@NotBlank
	@NotNull
	private String email;
	
	@Column(name="password")	
	@NotBlank
	@NotNull
	private String password;
	
	@Column(name="website")
	@NotBlank
	@NotNull
	private String website;
	
	@Column(name="phone_number")
	@NotBlank
	@NotNull
	private String phoneNumber;
	
	@Column(name="is_verified")
	private boolean isVerified = false;
	
	@Column(name="updated_date")
	private LocalDate updatedDate = LocalDate.now();
	

	@Column(name = "employer_id")
	private int employerId;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employerUpdate")
	private List<EmployerUpdateConfirm> employerUpdateConfirms;
	
}
