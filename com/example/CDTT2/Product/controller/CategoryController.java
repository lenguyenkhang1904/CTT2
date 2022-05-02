package com.example.CDTT2.Product.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CDTT2.Genneric.GenericController;
import com.example.CDTT2.Product.dto.SaveCategoryDto;
import com.example.CDTT2.Product.model.Category;

@RestController
@RequestMapping("/api/category")
public class CategoryController extends GenericController<SaveCategoryDto, Category, Long, BindingResult> {

}
