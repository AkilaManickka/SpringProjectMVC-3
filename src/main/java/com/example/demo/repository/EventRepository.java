package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

	List<Event> findByCreatedByUsername(String username);
}
