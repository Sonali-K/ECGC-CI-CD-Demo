package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity

public class Bank {

	@Id
	private int id;
	private String name;
	private String ifsccode;
	private String bankaddress;
	private String banktype;
	private String country;
	private String city;

	

	public Bank() {
		super();
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getIfsccode() {
		return ifsccode;
	}


	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}


	public String getBankaddress() {
		return bankaddress;
	}


	public void setBankaddress(String bankaddress) {
		this.bankaddress = bankaddress;
	}


	public String getBanktype() {
		return banktype;
	}


	public void setBanktype(String banktype) {
		this.banktype = banktype;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", ifsccode=" + ifsccode + ", bankaddress=" + bankaddress
				+ ", banktype=" + banktype + ", country=" + country + "]";
	}
	
	
	
	
}
