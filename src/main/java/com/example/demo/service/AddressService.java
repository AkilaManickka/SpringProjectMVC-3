package com.example.demo.service;

import java.util.List;

import com.example.demo.Model.Address;
import com.example.demo.Model.Event;



public interface AddressService {
	
	Address get(Long id);

	void delete(Long id);
	 void save(Address add, String Username);
	 List<Address> findUserAddress(String username);
	 
 

}
