package com.example.CDTT2.Genneric;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.CDTT2.CommonData.AbstractEntity;

public interface IGenericService<DTO, T extends AbstractEntity, ID> {
	public T save(DTO dto);

	public T update(DTO dto);

	public void delete(ID id);

	public List<T> findAll();
	
	public Optional<T> findById(ID id);
}
