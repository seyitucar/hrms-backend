package com.easyaudit.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyaudit.entities.concretes.SubCategory;

public interface SubCategoryDao extends JpaRepository<SubCategory, Integer> {

}
