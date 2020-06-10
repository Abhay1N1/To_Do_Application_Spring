package com.abhay.springboot.todomanagement.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Welcomecontr {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUserName());
		return "welcome";
	}

	private String getLoggedinUserName() {
		Object p = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (p instanceof UserDetails) {
			return ((UserDetails) p).getUsername();
		}
		
		return p.toString();
	}

}