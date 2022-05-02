package com.example.CDTT2.Product.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CDTT2.Genneric.GenericController;
import com.example.CDTT2.Product.dto.SaveAuthorDto;
import com.example.CDTT2.Product.model.Author;

@RequestMapping("/api/author")
@RestController
public class AuthorController extends GenericController<SaveAuthorDto, Author, Long, BindingResult> {

}
