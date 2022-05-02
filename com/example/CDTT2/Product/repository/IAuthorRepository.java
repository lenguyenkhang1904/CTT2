package com.example.CDTT2.Product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CDTT2.Product.model.Author;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Long> {

}
