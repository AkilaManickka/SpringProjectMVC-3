package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Role;



public interface RoleRepository  extends JpaRepository<Role, Long>{

}
