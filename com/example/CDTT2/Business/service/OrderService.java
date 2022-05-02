package com.example.CDTT2.Business.service;

import org.springframework.stereotype.Service;

import com.example.CDTT2.Business.dto.SaveOrderDto;
import com.example.CDTT2.Business.model.Order;
import com.example.CDTT2.Business.repository.IOrderRepository;
import com.example.CDTT2.Genneric.GenericService;
import com.example.CDTT2.Genneric.MapModelToDto;
import com.example.CDTT2.User.model.User;
import com.example.CDTT2.User.repository.IUserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService extends GenericService<SaveOrderDto, Order, Long> implements IOrderService {
	
	private IOrderRepository iOrderRepository;
	
	private MapModelToDto mapModelToDto;
	
	private IUserRepository iUserRepository;
	
	@Override
	public Order save(SaveOrderDto dto) {
		try {
			Order order=new Order();
			
			order=(Order)mapModelToDto.mapper(dto, order);
			
			User user=iUserRepository.getOne(dto.getUserId());
			if(user!=null)
				order.setUser(user);
			
			return iOrderRepository.save(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Order update(SaveOrderDto dto) {
		try {
			Order order=iOrderRepository.getOne(dto.getId());
			
			order=(Order)mapModelToDto.mapper(dto, order);
			
			User user=iUserRepository.getOne(dto.getUserId());
			if(user!=null)
				order.setUser(user);
			
			return iOrderRepository.save(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
