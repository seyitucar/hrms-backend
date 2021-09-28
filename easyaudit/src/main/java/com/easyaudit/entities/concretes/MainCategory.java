package com.easyaudit.entities.concretes;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "main_categories")
public class MainCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "main_category_name")
	@NotBlank
	@NotNull
	private String mainCategoryName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "mainCategory" )
	private List<Question> questions;
	
	@JsonIgnore
	@OneToMany(mappedBy = "mainCategory")
	private List<SubCategory> subCategories;
}
