package com.easyaudit.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="audits")
public class Audit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "audit_report_number")
	private String auditReportNumber;
	
	@Column(name = "audit_date")
	private LocalDate auditDate;
	
	@ManyToOne()
	@JoinColumn(name = "audit_type_id")
	private AuditType auditType;
	
	@Column(name="audit_score")
	private double auditScore;
	
	@ManyToOne()
	@JoinColumn(name = "auditor_id")
	private Auditor auditor;
	
	@ManyToOne()
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;

}
