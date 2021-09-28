package com.easyaudit.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyaudit.entities.concretes.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
