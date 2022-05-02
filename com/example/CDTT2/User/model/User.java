package com.example.CDTT2.User.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.CDTT2.Business.model.Order;
import com.example.CDTT2.CommonData.AbstractEntity;
import com.example.CDTT2.Product.model.Cart;
import com.example.CDTT2.Role.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_table")
@Getter
@Setter
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
public class User extends AbstractEntity {
	
	private String email;
	
	private String phone;
	
	private String username;
	
	private String password;
	
	private String fbUserId;
	
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
	@JoinTable(name = "User_Role_CDTT2", joinColumns = @JoinColumn(name = "id_User"), inverseJoinColumns = @JoinColumn(name = "id_Role"))
	private Set<Role> roles = new HashSet<>();
	
	@OneToMany(mappedBy  = "user")
	@JsonIgnore
	private Set<Cart> cart=new HashSet<>();
	
	@OneToMany(mappedBy  = "user")
	@JsonIgnore
	private Set<Order> order=new HashSet<>();

}
