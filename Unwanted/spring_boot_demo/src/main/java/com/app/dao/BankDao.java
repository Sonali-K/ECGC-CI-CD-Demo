package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Bank;

@Repository
public interface BankDao extends JpaRepository<Bank, Integer>{
	//Bank findByName(String name);
	Bank findById(int id);
}
