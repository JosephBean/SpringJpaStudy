package com.java.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ex10")
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ex1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no")
	private int no;
	
	@Column(length = 50, nullable = false)
	private String title;
	
	private String content;
	
	@Column(nullable = false, columnDefinition = "boolean default false")
	private boolean accept;
	
	@Column(name = "regDate", nullable = false)
	@CreationTimestamp
	private LocalDateTime regDate;

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	} 
	
}
