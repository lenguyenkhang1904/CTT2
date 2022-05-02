package com.example.CDTT2.Genneric;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CDTT2.CommonData.AbstractEntity;

import io.swagger.annotations.Authorization;

public abstract class GenericService<DTO,T extends AbstractEntity ,ID> implements IGenericService<DTO,T,ID>  {

	@Autowired
	private JpaRepository<T, ID> repository;
	
	@Override
	public T save(DTO dto) {
		
		return null;
	}
	
	@Override
	public List<T> findAll() {
		
		return  repository.findAll();
	}
	
	@Override
	public void delete(ID id) {
		repository.deleteById(id);
		
	}
	
	
	@Override
	public T update(DTO dto) {
		
		return null;
	}
	
	@Override
	public Optional<T> findById(ID id) {
		
		return repository.findById(id);
	}
	
}
