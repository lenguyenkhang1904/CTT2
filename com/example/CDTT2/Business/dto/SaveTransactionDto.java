package com.example.CDTT2.Business.dto;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.example.CDTT2.Business.model.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveTransactionDto {

	private Long id;
	
	private String tranStatus;

	private int tranAmount;

	private String tranMessage;

	@OneToOne(fetch = FetchType.LAZY)
	private Long orderId;
}
