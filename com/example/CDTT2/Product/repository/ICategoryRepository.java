package com.example.CDTT2.Product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CDTT2.Product.dto.SaveCategoryDto;
import com.example.CDTT2.Product.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
