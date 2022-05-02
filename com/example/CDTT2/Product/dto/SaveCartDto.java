package com.example.CDTT2.Product.dto;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.example.CDTT2.Product.model.Product;
import com.example.CDTT2.User.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveCartDto {
	
	
	private Long id;
	
	private int quanlity;
	
	
	private Long productId;
	
	
	private Long userId;
}
