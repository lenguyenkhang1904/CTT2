package com.example.CDTT2.Business.service;

import org.springframework.stereotype.Service;

import com.example.CDTT2.Business.dto.SaveTransactionDto;
import com.example.CDTT2.Business.model.Order;
import com.example.CDTT2.Business.model.Transaction;
import com.example.CDTT2.Business.repository.IOrderRepository;
import com.example.CDTT2.Business.repository.ITransactionRepository;
import com.example.CDTT2.Genneric.GenericService;
import com.example.CDTT2.Genneric.MapModelToDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionService extends GenericService<SaveTransactionDto, Transaction, Long> implements ITransactionService {
	
	private ITransactionRepository iTransactionRepository;
	
	private IOrderRepository iOrderRepository;
	
	private MapModelToDto mapModelToDto;
	
	@Override
	public Transaction save(SaveTransactionDto dto) {
		try {
			Transaction transaction=new Transaction();
			
			transaction= (Transaction) mapModelToDto.mapper(dto, transaction);
			
			Order order=iOrderRepository.getOne(dto.getOrderId());
			
			
			if(order!=null)
				transaction.setOrder(order);
				
			return iTransactionRepository.save(transaction);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public Transaction update(SaveTransactionDto dto) {
		try {
			Transaction transaction=iTransactionRepository.getOne(dto.getId());
			
			transaction= (Transaction) mapModelToDto.mapper(dto, transaction);
			
			Order order=iOrderRepository.getOne(dto.getOrderId());
			
			
			if(order!=null)
				transaction.setOrder(order);
				
			return iTransactionRepository.save(transaction);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
}
