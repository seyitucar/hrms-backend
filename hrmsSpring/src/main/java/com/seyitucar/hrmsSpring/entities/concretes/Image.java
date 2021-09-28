package com.seyitucar.hrmsSpring.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="images")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "url")
	private String url;
	
    @Column(name = "uploaded_at")
    private LocalDate uploadedAt;
	
    @JsonIgnoreProperties({"firstName","lastName","email","password","nationalityId","birthYear"})
	@OneToOne()
	@JoinColumn(name = "employee_id")
	private Employee employee;
    
    @JsonIgnore
	@OneToOne()
	@JoinColumn(name = "resume_id")
	private Resume resume;

}
