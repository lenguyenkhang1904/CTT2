package com.example.CDTT2.Product.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.CDTT2.CommonData.AbstractEntity;
import com.example.CDTT2.Ultils.DateUltils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
public class Product extends AbstractEntity {
	
	private String productName;
	
	private Double price;
	
	private String description;
	
	private Double discount;
	
	private String imageLink;
	
	private String brandName;
	
	private int quantity;
	
	private int sold;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = DateUltils.Date_Time_Format )
	@DateTimeFormat(pattern = DateUltils.Date_Time_Format)
	private LocalDateTime dateFirstAvailable;
	
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private Set<Cart> cart=new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Author author;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Publisher publisher;
	

}
