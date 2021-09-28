package com.easyaudit.entities.concretes;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questions")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;	
	
	@Column(name = "audit_question")
	private String auditQuestion;
	
	@ManyToOne()
	@JoinColumn(name = "main_category_id")
	private MainCategory mainCategory;
	
	@ManyToOne()
	@JoinColumn(name = "sub_category_id")
	private SubCategory subCategory;

}
