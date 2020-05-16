package com.keycloak.controller;

import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KeycloakController {
    
	@GetMapping(path="/")
	public String getIndex()
	{
		return "index";
		
	}
	
	@GetMapping(path="/persons")
	public String getPersons(Model model)
	{
		model.addAttribute("persons",Arrays.asList("Johan","David","Peter"));
		return "persons";
	}

	@GetMapping(path="/lagout")
	public String logOut(HttpServletRequest request) throws ServletException{
		request.logout();
		return "/";
	}
	
}
