package com.easyaudit.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyaudit.entities.concretes.Supplier;

public interface SupplierDao extends JpaRepository<Supplier, Integer> {

}
