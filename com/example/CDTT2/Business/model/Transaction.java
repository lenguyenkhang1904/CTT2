package com.example.CDTT2.Business.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.CDTT2.CommonData.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
public class Transaction extends AbstractEntity {
	
	
	private String tranStatus;
	
	private int tranAmount;
	
	private String tranMessage;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Order order;
	
}
