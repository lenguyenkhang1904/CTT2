package com.example.CDTT2.Product.dto;

import java.time.LocalDateTime;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.CDTT2.Product.model.Author;
import com.example.CDTT2.Product.model.Category;
import com.example.CDTT2.Product.model.Publisher;
import com.example.CDTT2.Ultils.DateUltils;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveProductDto {

	private Long id;
	
	private String productName;

	private Double price;

	private String description;

	private Double discount;

	private String imageLink;

	private int quantity;

	private int sold;

	private LocalDateTime dateFirstAvailable;

	private Long categoryId;

	private Long authorId;

	private Long publisherId;
}
