package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.domain.TestEntity;

public interface TestEntityRepository extends JpaRepository<TestEntity, Integer> {

	public List<TestEntity> findByTxtContaining(String txt);
	
}
