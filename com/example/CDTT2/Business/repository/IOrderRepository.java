package com.example.CDTT2.Business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CDTT2.Business.model.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

}
