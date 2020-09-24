package com.example.demo.service;

import java.util.List;

import com.example.demo.Model.Address;



public interface AddressService {
	
	 void save(Address add, String Username);
	 List<Address> findUserAddress(String username);
 

}
