package com.example.CDTT2.Business.service;

import com.example.CDTT2.Business.dto.SaveTransactionDto;
import com.example.CDTT2.Business.model.Transaction;
import com.example.CDTT2.Genneric.IGenericService;

public interface ITransactionService extends IGenericService<SaveTransactionDto, Transaction, Long> {

}
