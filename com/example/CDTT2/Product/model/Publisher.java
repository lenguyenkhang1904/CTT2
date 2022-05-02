package com.example.CDTT2.Product.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.CDTT2.CommonData.AbstractEntity;
import com.example.CDTT2.Ultils.DateUltils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "publisher")
@Getter
@Setter
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
public class Publisher extends AbstractEntity {
	
	private String namePublisher;
	
	private String email;
	
	private String informationPublisher;
	
	@OneToMany(mappedBy = "publisher")
	@JsonIgnore
	private Set<Product> products=new HashSet<>();
}
