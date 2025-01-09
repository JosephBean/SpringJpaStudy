package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.domain.Ex1;

public interface Ex1Repository extends JpaRepository<Ex1, Integer> {

	List<Ex1> findByAccept(boolean accept);
	
}
