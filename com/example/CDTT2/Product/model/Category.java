package com.example.CDTT2.Product.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.CDTT2.CommonData.AbstractEntity;
import com.example.CDTT2.User.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "category")
@Getter
@Setter
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
public class Category extends AbstractEntity {
	
	private String categoryName;
	
	@OneToMany(mappedBy = "category")
	@JsonIgnore
	private Set<Product> products=new HashSet<>();

}
