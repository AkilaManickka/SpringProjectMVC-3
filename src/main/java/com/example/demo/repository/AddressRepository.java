package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
	
	//List<Address> findByCreatedByUsername(String username);

}
