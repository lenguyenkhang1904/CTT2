package com.example.CDTT2.Product.service;

import org.springframework.stereotype.Service;

import com.example.CDTT2.Genneric.GenericService;
import com.example.CDTT2.Genneric.MapModelToDto;
import com.example.CDTT2.Product.dto.SaveAuthorDto;
import com.example.CDTT2.Product.dto.SaveCategoryDto;
import com.example.CDTT2.Product.model.Author;
import com.example.CDTT2.Product.model.Category;
import com.example.CDTT2.Product.repository.IAuthorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorService extends GenericService<SaveAuthorDto, Author, Long> implements IAuthorService {

	private IAuthorRepository iAuthorRepository;

	private MapModelToDto mapModelToDto;

	@Override
	public Author save(SaveAuthorDto dto) {
		try {
			Author author = new Author();

			author = (Author) mapModelToDto.mapper(dto, author);

			return iAuthorRepository.save(author);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public Author update(SaveAuthorDto dto) {
		try {
			Author author = iAuthorRepository.getOne(dto.getId());

			author = (Author) mapModelToDto.mapper(dto, author);

			return iAuthorRepository.save(author);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
