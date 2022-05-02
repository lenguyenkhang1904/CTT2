package com.example.CDTT2.Product.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.CDTT2.CommonData.AbstractEntity;
import com.example.CDTT2.Role.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "author")
@Getter
@Setter
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
public class Author extends AbstractEntity {

	private String fullName;
	private String website;
	private String note;
	
	@OneToMany(mappedBy = "author")
	@JsonIgnore
	private Set<Product> products=new HashSet<>();
	
}
