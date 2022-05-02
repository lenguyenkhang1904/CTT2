package com.example.CDTT2.Product.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.CDTT2.CommonData.AbstractEntity;
import com.example.CDTT2.Ultils.DateUltils;
import com.example.CDTT2.User.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart")
@Getter
@Setter
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
public class Cart extends AbstractEntity{

	
	private int quanlity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
}
