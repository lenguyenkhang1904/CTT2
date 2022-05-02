package com.example.CDTT2.Product.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CDTT2.Genneric.GenericController;
import com.example.CDTT2.Product.dto.SavePublisherDto;
import com.example.CDTT2.Product.model.Publisher;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController extends GenericController<SavePublisherDto, Publisher, Long, BindingResult> {

}
