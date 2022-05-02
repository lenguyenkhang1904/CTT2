package com.example.CDTT2.Product.service;

import com.example.CDTT2.Genneric.IGenericService;
import com.example.CDTT2.Product.dto.SaveCategoryDto;
import com.example.CDTT2.Product.model.Category;

public interface ICategoryService extends  IGenericService<SaveCategoryDto, Category, Long> {

}
