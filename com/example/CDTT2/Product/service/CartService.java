package com.example.CDTT2.Product.service;

import org.springframework.stereotype.Service;

import com.example.CDTT2.Genneric.GenericService;
import com.example.CDTT2.Genneric.MapModelToDto;
import com.example.CDTT2.Product.dto.SaveCartDto;
import com.example.CDTT2.Product.dto.SaveCategoryDto;
import com.example.CDTT2.Product.model.Cart;
import com.example.CDTT2.Product.model.Category;
import com.example.CDTT2.Product.repository.ICartRepository;
import com.example.CDTT2.Product.repository.IProductRepository;
import com.example.CDTT2.User.repository.IUserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartService  extends GenericService<SaveCartDto, Cart, Long> implements ICartService {
  
	private ICartRepository iCartRepository;
	
	private MapModelToDto mapModelToDto;
	
	private IUserRepository iUserRepository;
	
	private IProductRepository iProductRepository;
	
	@Override
	public Cart save(SaveCartDto dto) {
		try {
			Cart cart =new Cart();
			
			cart = (Cart)mapModelToDto.mapper(dto, cart);
			
			if(iUserRepository.getOne(dto.getUserId())!=null)
				cart.setUser(iUserRepository.getOne(dto.getUserId()));
			
			if(iProductRepository.getOne(dto.getProductId())!=null)
				cart.setProduct(iProductRepository.getOne(dto.getProductId()));
				
			return iCartRepository.save(cart);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public Cart update(SaveCartDto dto) {
		try {
			Cart cart =iCartRepository.getOne(dto.getId());
			
			cart = (Cart)mapModelToDto.mapper(dto, cart);
			
			if(iUserRepository.getOne(dto.getUserId())!=null)
				cart.setUser(iUserRepository.getOne(dto.getUserId()));
			
			if(iProductRepository.getOne(dto.getProductId())!=null)
				cart.setProduct(iProductRepository.getOne(dto.getProductId()));
				
			return iCartRepository.save(cart);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
