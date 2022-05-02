package com.example.CDTT2.Role.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.CDTT2.CommonData.AbstractEntity;
import com.example.CDTT2.User.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role")
@Getter
@Setter
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
public class Role extends AbstractEntity {
	
	
	private String roleName;
	
	private String description;
	
	@ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<User> users=new HashSet<>();
	
	public Role addRoleName(String name)
	{
		this.roleName=name;
		return this;
	}

}
