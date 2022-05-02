package com.example.CDTT2.Business.dto;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.example.CDTT2.Business.model.Transaction;
import com.example.CDTT2.User.model.User;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SaveOrderDto {
	
	private Long id;
	
	private int amount;
	
	private int discountMount;
	
	private String shipName;
	
	private String shipPhone;
	
	private String shipAddress;
	
	private String orderNote;
	
	
	private Long userId;
	

}
