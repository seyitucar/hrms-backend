package com.easyaudit.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyaudit.entities.concretes.MainCategory;

public interface MainCategoryDao extends JpaRepository<MainCategory, Integer> {

}
