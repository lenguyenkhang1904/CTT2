package com.example.CDTT2.Product.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.CDTT2.Genneric.GenericService;
import com.example.CDTT2.Genneric.MapModelToDto;
import com.example.CDTT2.Product.dto.SaveProductDto;
import com.example.CDTT2.Product.model.Product;
import com.example.CDTT2.Product.repository.IAuthorRepository;
import com.example.CDTT2.Product.repository.ICategoryRepository;
import com.example.CDTT2.Product.repository.IProductRepository;
import com.example.CDTT2.Product.repository.IPublisherRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class ProductService extends GenericService<SaveProductDto, Product, Long> implements IProductService {

	private IProductRepository iProductRepository;

	private ICategoryRepository iCategoryRepository;

	private IAuthorRepository iAuthorRepository;

	private IPublisherRepository iPublisherRepository;

	private MapModelToDto mapModelToDto;

	@Override
	public Product save(SaveProductDto dto) {
		try {
			Product product = new Product();
			product = (Product) mapModelToDto.mapper(dto, product);

			if (iAuthorRepository.getOne(dto.getAuthorId()) != null)
				product.setAuthor(iAuthorRepository.getOne(dto.getAuthorId()));

			if (iCategoryRepository.getOne(dto.getCategoryId()) != null)
				product.setCategory(iCategoryRepository.getOne(dto.getCategoryId()));

			if (iPublisherRepository.getOne(dto.getPublisherId()) != null)
				product.setPublisher(iPublisherRepository.getOne(dto.getPublisherId()));

			return iProductRepository.save(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Product update(SaveProductDto dto) {
		try {
			Product product = iProductRepository.getOne(dto.getId());
			product = (Product) mapModelToDto.mapper(dto, product);

			if (iAuthorRepository.getOne(dto.getAuthorId()) != null)
				product.setAuthor(iAuthorRepository.getOne(dto.getAuthorId()));

			if (iCategoryRepository.getOne(dto.getCategoryId()) != null)
				product.setCategory(iCategoryRepository.getOne(dto.getCategoryId()));

			if (iPublisherRepository.getOne(dto.getPublisherId()) != null)
				product.setPublisher(iPublisherRepository.getOne(dto.getPublisherId()));

			return iProductRepository.save(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
