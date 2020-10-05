package com.example.demo.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Address;
import com.example.demo.Model.Event;
import com.example.demo.Model.User;
import com.example.demo.service.AddressService;
import com.example.demo.service.UserService;

@Controller
public class AddressController {
	private static final Logger log = LoggerFactory.getLogger(AddressController.class);
	
	@Autowired
	AddressService addser;
	@Autowired 
	UserService userService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}	
	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public String showAddress(ModelMap model,Principal principal) {
		model.put("address", addser.findUserAddress(principal.getName()));
		System.out.println("username = " +principal.getName());
		return "address";
	}
	@RequestMapping(value = "/add-address", method = RequestMethod.GET)
	public String showAddAddressPage(ModelMap model, Principal principal) {
		model.addAttribute("AddressForm", new Address(0l,userService.findByUsername(principal.getName()),
				"name","address","city","state","country",6565,new Date()));
		return "add-address";
	}
		
	@RequestMapping(value = "/add-address", method = RequestMethod.POST)
	public String addaddress(ModelMap model, @ModelAttribute("AddressForm") Address add, BindingResult result,Principal principal) {

		if (result.hasErrors()) {
			return "address";
		}

		addser.save(add ,principal.getName());
		return "redirect:/address";
	}


	@RequestMapping(value = "/delete-address", method = RequestMethod.GET)
	public String deleteaddress(@RequestParam long id) {
		System.out.println(id);

		if(id==0)
			throw new RuntimeException("Something went wrong");
		
		addser.delete(id);
		return "redirect:/address";
	}

	@RequestMapping(value = "/update-address", method = RequestMethod.GET)
	public String showUpdateaddressPage(@RequestParam long id, ModelMap model,Principal principal) {
		Address address = addser.get(id);
		model.put("AddressForm", address);
		return "add-address";
	}

	@RequestMapping(value = "/update-address", method = RequestMethod.POST)
	public String updateaddress(ModelMap model, @ModelAttribute("AddressForm") Address address,
			BindingResult result,Principal principal) {

		if (result.hasErrors()) {
			return "add-address";
		}

		addser.save(address,principal.getName());

		return "redirect:/address";
	}

}
