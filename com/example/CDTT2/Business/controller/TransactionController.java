package com.example.CDTT2.Business.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CDTT2.Business.dto.SaveTransactionDto;
import com.example.CDTT2.Business.model.Transaction;
import com.example.CDTT2.Genneric.GenericController;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController extends GenericController<SaveTransactionDto, Transaction, Long, BindingResult> {

}
