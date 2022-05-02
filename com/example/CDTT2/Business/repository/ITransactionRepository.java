package com.example.CDTT2.Business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CDTT2.Business.model.Transaction;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Long> {

}
