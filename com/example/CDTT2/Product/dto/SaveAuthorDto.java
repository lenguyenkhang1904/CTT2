package com.example.CDTT2.Product.dto;

import javax.persistence.SqlResultSetMapping;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveAuthorDto {

	private Long id;
	private String fullName;
	private String website;
	private String note;
}
