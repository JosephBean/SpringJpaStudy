package com.java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.domain.TestEntity;
import com.java.repository.TestEntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TestService {

	private final TestEntityRepository testEntityRepository;
	
	public List<TestEntity> findAll() {
		return testEntityRepository.findAll();
	}
	
	public void save(String txt) {
		TestEntity tEntity = new TestEntity();
		tEntity.setTxt(txt);
		testEntityRepository.save(tEntity);
	}
	
	public void edit(String txt, int no) {
		TestEntity tEntity = testEntityRepository.findById(no).orElseThrow();
		tEntity.setTxt2(txt);
		testEntityRepository.save(tEntity);
	}
	
	public void del(int no) {
		TestEntity tEntity = testEntityRepository.findById(no).orElseThrow();
		testEntityRepository.delete(tEntity);
	}
	
	public List<TestEntity> findList(String txt) {
		if(txt == null) {
			return findAll();
		} else {
			return testEntityRepository.findByTxtContaining(txt);
		}
	}
	
}
