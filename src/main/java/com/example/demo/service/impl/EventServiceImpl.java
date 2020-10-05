package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Event;
import com.example.demo.Model.User;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;
import com.example.demo.service.UserService;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	private UserService userService;
	
    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event get(Long id) {
    	return eventRepository.getOne(id);
    }
    
    @Override
    public void delete(Long id) {
    	//eventRepository.deleteById(id);
    	Event event=eventRepository.getOne(id);
    	event.setDeleted(true);
    	eventRepository.save(event);
    }

    @Override
    public void save(Event event, String userName) {
    	User sessionUser = userService.findByUsername(userName);
    	event.setCreatedBy(sessionUser);
    	eventRepository.save(event);
    }
    
    @Override
    public List<Event> findUserEvents(String username) {
    	return eventRepository.findByCreatedByUsernameAndDeletedIsFalse(username);
    }


}
