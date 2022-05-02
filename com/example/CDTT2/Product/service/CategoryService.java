package com.example.CDTT2.Product.service;

import org.springframework.stereotype.Service;

import com.example.CDTT2.Genneric.GenericService;
import com.example.CDTT2.Genneric.MapModelToDto;
import com.example.CDTT2.Product.dto.SaveCartDto;
import com.example.CDTT2.Product.dto.SaveCategoryDto;
import com.example.CDTT2.Product.model.Category;
import com.example.CDTT2.Product.repository.ICategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService extends GenericService<SaveCategoryDto, Category, Long> implements ICategoryService{
	
	private ICategoryRepository iCategoryRepository;
	
	private MapModelToDto mapModelToDto;
	
	@Override
	public Category save(SaveCategoryDto dto) {
		try {
			Category category=new Category();
			
			category=(Category)mapModelToDto.mapper(dto, category);
			
			return iCategoryRepository.save(category);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	@Override
	public Category update(SaveCategoryDto dto) {
		try {
			Category category=iCategoryRepository.getOne(dto.getId());
			
			category=(Category)mapModelToDto.mapper(dto, category);
			
			return iCategoryRepository.save(category);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
