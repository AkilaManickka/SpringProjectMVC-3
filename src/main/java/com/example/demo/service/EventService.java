package com.example.demo.service;

import java.util.List;

import com.example.demo.Model.Event;


public interface EventService {
	
	Event get(Long id);

	void delete(Long id);

	void save(Event event, String userName);

	List<Event> findUserEvents(String username);


}
