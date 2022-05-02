package com.example.CDTT2.Business.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CDTT2.Business.dto.SaveOrderDto;
import com.example.CDTT2.Business.model.Order;
import com.example.CDTT2.Genneric.GenericController;

@RestController
@RequestMapping("/api/order")
public class OrderController extends GenericController<SaveOrderDto, Order, Long, BindingResult> {

}
