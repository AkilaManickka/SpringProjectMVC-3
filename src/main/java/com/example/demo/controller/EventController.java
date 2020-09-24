package com.example.demo.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.example.demo.Model.Event;
import com.example.demo.service.EventService;
import com.example.demo.service.UserService;



@Controller
public class EventController {
	
    @Autowired
    
    private UserService userService;
    
    @Autowired
    private EventService eventService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = {"/","/events"}, method = RequestMethod.GET)
	public String showevents(ModelMap model,Principal principal) {
		model.put("events", eventService.findUserEvents(principal.getName()));
		return "events";
	}

	@RequestMapping(value = "/add-event", method = RequestMethod.GET)
	public String showAddeventPage(ModelMap model, Principal principal) {
		model.addAttribute("eventForm", new Event(0l, userService.findByUsername(principal.getName()),
				"Default Desc", new Date(), false));
		return "event";
	}

	@RequestMapping(value = "/delete-event", method = RequestMethod.GET)
	public String deleteevent(@RequestParam long id) {

		if(id==0)
			throw new RuntimeException("Something went wrong");
		
		eventService.delete(id);
		return "redirect:/events";
	}

	@RequestMapping(value = "/update-event", method = RequestMethod.GET)
	public String showUpdateeventPage(@RequestParam long id, ModelMap model,Principal principal) {
		Event event = eventService.get(id);
		model.put("eventForm", event);
		return "event";
	}

	@RequestMapping(value = "/update-event", method = RequestMethod.POST)
	public String updateevent(ModelMap model, @ModelAttribute("eventForm") Event event,
			BindingResult result,Principal principal) {

		if (result.hasErrors()) {
			return "event";
		}

		eventService.save(event,principal.getName());

		return "redirect:/events";
	}

	@RequestMapping(value = "/add-event", method = RequestMethod.POST)
	public String addevent(ModelMap model, @ModelAttribute("eventForm") Event event, BindingResult result,Principal principal) {

		if (result.hasErrors()) {
			return "event";
		}

		eventService.save(event,principal.getName());
		return "redirect:/events";
	}
	
}
