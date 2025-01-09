package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.java.domain.TestEntity;

public interface TestEntityRepository  
			// extends JpaRepository<TestEntity, Integer> 
{

	public List<TestEntity> findByTxtContaining(String txt);
	
//	@Query(value = "select t.* from test as t where t.txt like %:txt%", nativeQuery = true)
//	public List<TestEntity> ft(@Param("txt") String txt);
	
}
