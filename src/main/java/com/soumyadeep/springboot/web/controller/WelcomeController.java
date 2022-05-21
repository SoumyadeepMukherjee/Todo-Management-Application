package com.soumyadeep.springboot.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		model.put("name", getLoggedinUserName());
		return "welcome";
	}

	// @RequestMapping(value = "/login", method = RequestMethod.POST)
	// public String showWelcomePage(ModelMap model, @RequestParam String name,
	// @RequestParam String password) {

	// boolean isValidUser = service.validateUser(name, password);

	// if (!isValidUser) {
	// model.put("errorMessage", "Invalid Credentials");
	// return "login";
	// }

	// model.put("name", name);
	// model.put("password", password);

	// return "welcome";
	// }

	private String getLoggedinUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

}
