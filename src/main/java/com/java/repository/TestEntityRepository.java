package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.domain.TestEntity;

public interface TestEntityRepository extends JpaRepository<TestEntity, Integer> {

}
