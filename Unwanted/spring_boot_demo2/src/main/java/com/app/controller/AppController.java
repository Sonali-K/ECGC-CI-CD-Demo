package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.model.Bank;
import com.app.service.BankService;


@RestController
@CrossOrigin
@RequestMapping("/bank")
public class AppController {
	
	@Autowired
	BankService service;
	RestTemplate restTemplate=new RestTemplate();
	
	@GetMapping("/getallbank")
	public List<Object> getAllBank()
	{
		System.out.println("inside controller");
		Object[] objects = restTemplate.getForObject( "http://localhost:8085/bank/getAllBank",Object[].class);
		return Arrays.asList(objects);
	}
	
	@GetMapping("/findbankbyid/{id}")
	public Bank findBank(@PathVariable int id) {
		System.out.println("controller la ala");
		return restTemplate.getForObject( "http://localhost:8085/bank/findbankbyid/"+id,Bank.class);
		
	}
	
	/*
	 * @GetMapping("/access") public List<Object> getBankById() { Object[] objects =
	 * restTemplate.getForObject(
	 * "http://localhost:8088/bank/getAllBank",Object[].class); return
	 * Arrays.asList(objects); }
	 */
	
	/*
	@PostMapping("/save")
	public String addBank(@RequestBody Bank bank) {
		System.out.println("rest server : add bank " + bank);
		service.savedetails(bank);
		return "Successfully added";
	}
	*/
	/*
	 * @PostMapping("/save") public String addMovie(@RequestParam int
	 * id,@RequestParam String name) { System.out.println("rest server : add movie "
	 * ); Bank b=new Bank(id, name);
	 * 
	 * service.savedetails(b); return "Successfully added"; }
	 */
	/*
	@GetMapping("/delete/{id}")
	public String deleteBank(@PathVariable int id) {
		System.out.println("rest server : delete bank " + id);
		service.deleteBank(id);
		return "Successfully deleted";
	}
	*/
	/*
	@PostMapping("/find/{name}")
	public Bank findBank(@PathVariable String name) {
		System.out.println("rest server : find bank " +name);
		Bank bank=service.findBank(name);
		System.out.println(bank);
		return bank;
	}
	*/
	/*@GetMapping("/getAllBank")
	public List<Bank> findAll(){
		List<Bank> bank= service.findAllBank();
		System.out.println("Bank data ="+bank);
		return bank;
	}
	*/
	
	
}
