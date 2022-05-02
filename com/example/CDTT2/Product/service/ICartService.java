package com.example.CDTT2.Product.service;

import com.example.CDTT2.Genneric.IGenericService;
import com.example.CDTT2.Product.dto.SaveCartDto;
import com.example.CDTT2.Product.model.Cart;

public interface ICartService extends IGenericService<SaveCartDto, Cart, Long> {

}
