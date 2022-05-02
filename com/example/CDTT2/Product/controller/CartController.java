package com.example.CDTT2.Product.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CDTT2.Genneric.GenericController;
import com.example.CDTT2.Product.dto.SaveCartDto;
import com.example.CDTT2.Product.model.Cart;

@RequestMapping("/api/cart")
@RestController
public class CartController extends GenericController<SaveCartDto, Cart, Long, BindingResult> {

}
