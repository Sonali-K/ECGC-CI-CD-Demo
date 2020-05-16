package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Bank;

@Repository
public interface BankDao extends JpaRepository<Bank, Integer>{
	Bank findByName(String name);
	List<Bank> findAll();
	
}
