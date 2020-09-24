package com.example.demo.controller;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Model.Address;
import com.example.demo.Model.Event;
import com.example.demo.service.AddressService;
import com.example.demo.service.UserService;

@Controller
public class AddressController {
	
	@Autowired
	AddressService addser;
	@Autowired 
	UserService userService;
	
	@RequestMapping(value = "/add-address", method = RequestMethod.POST)
	public String addaddress(ModelMap model, @ModelAttribute("AddressForm") Address add, BindingResult result,Principal principal) {

		if (result.hasErrors()) {
			return "Address";
		}

		addser.save(add ,principal.getName());
		return "redirect:/Address";
	}

}
