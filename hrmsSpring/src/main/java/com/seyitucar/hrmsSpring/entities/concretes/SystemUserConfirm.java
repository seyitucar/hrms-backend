package com.seyitucar.hrmsSpring.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="system_user_confirms")
@Inheritance(strategy = InheritanceType.JOINED)
public class SystemUserConfirm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@Column(name="confirm_date")
	private LocalDate confirmDate = LocalDate.now();
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private SystemUser systemUser;
	
}
