package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Address;

import com.example.demo.Model.User;
import com.example.demo.repository.AddressRepository;

import com.example.demo.service.AddressService;
import com.example.demo.service.UserService;


@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private UserService userService;
	
    @Autowired
    private AddressRepository addRepository;


    @Override
    public void save(Address add, String userName) {
    	User sessionUser = userService.findByUsername(userName);
    	add.setUpdatedby(sessionUser);
    	addRepository.save(add);
    }


	@Override
	public List<Address> findUserAddress(String username) {
		// TODO Auto-generated method stub
		return null;
	}
    
   // @Override
    //public List<Address> findUserAddress(String username) {
    	//return addRepository.findByCreatedByUsername(username);
    //}

}
