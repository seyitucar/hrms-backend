package com.easyaudit.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyaudit.entities.concretes.Question;

public interface QuestionDao extends JpaRepository<Question, Integer> {

}
