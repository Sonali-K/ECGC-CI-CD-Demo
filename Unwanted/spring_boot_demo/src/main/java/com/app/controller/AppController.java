package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Bank;
import com.app.service.BankService;


@RestController
@CrossOrigin
@RequestMapping("/bank")
public class AppController {
	
	@Autowired
	BankService service;
	
		//http://localhost:8085/bank/getAllBank

	@GetMapping("/getAllBank")
	public List<Bank> findAll(){
		System.out.println("inside demo application");
		List<Bank> bank= service.findAllBank();
		System.out.println("Bank data ="+bank);
		return bank;
	}
	
	@PostMapping("/save")
	public String addBank(@RequestBody Bank bank) {
		System.out.println("rest server : add bank " + bank);
		service.savedetails(bank);
		return "Bank Added Successfully";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteBank(@PathVariable int id) {
		service.deleteBank(id);
		return "Successfully deleted";
	}
		
	@GetMapping("/findbankbyid/{id}")
	public Bank findBank(@PathVariable int id) {
		System.out.println("function called  : find bank by id " +id);
		Bank bank=service.findBankId(id);
		return bank;
	}
}
