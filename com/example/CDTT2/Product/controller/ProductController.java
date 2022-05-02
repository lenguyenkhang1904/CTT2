package com.example.CDTT2.Product.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CDTT2.Genneric.GenericController;
import com.example.CDTT2.Product.dto.SaveProductDto;
import com.example.CDTT2.Product.model.Product;

@RequestMapping("/api/product")
@RestController
public class ProductController extends GenericController<SaveProductDto,Product,Long,BindingResult> {

}
