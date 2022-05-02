package com.example.CDTT2.Business.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.query.Jpa21Utils;

import com.example.CDTT2.CommonData.AbstractEntity;
import com.example.CDTT2.Product.model.Product;
import com.example.CDTT2.User.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_table")
@Getter
@Setter
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
public class Order extends AbstractEntity{
	
	
	private int amount;
	
	private int discountMount;
	
	private String shipName;
	
	private String shipPhone;
	
	private String shipAddress;
	
	private String orderNote;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@OneToOne(mappedBy = "order")
	@JsonIgnore
	private Transaction transaction;
	
}
