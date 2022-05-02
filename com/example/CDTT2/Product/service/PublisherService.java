package com.example.CDTT2.Product.service;

import org.springframework.stereotype.Service;

import com.example.CDTT2.Genneric.GenericService;
import com.example.CDTT2.Genneric.MapModelToDto;
import com.example.CDTT2.Product.dto.SaveCategoryDto;
import com.example.CDTT2.Product.dto.SavePublisherDto;
import com.example.CDTT2.Product.model.Category;
import com.example.CDTT2.Product.model.Publisher;
import com.example.CDTT2.Product.repository.IPublisherRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PublisherService  extends GenericService<SavePublisherDto, Publisher, Long> implements IPublisherService {
     private IPublisherRepository iPublisherRepository;
     
     private MapModelToDto mapModelToDto;
     
     @Override
    public Publisher save(SavePublisherDto dto) {
    	try {
			Publisher publisher=new Publisher();
			
			publisher =(Publisher) mapModelToDto.mapper(dto, publisher);
			
			return iPublisherRepository.save(publisher);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return null;
    }
     
     @Override
    public Publisher update(SavePublisherDto dto) {
    		try {
    			Publisher publisher=iPublisherRepository.getOne(dto.getId());
    			
    			publisher =(Publisher) mapModelToDto.mapper(dto, publisher);
    			
    			return iPublisherRepository.save(publisher);
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        	
        	return null;
    }
}
