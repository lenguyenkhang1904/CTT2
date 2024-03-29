package com.example.CDTT2.Role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.CDTT2.Role.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

	@Query("SELECT r FROM Role r WHERE r.roleName=:name")
	Role findByRoleNameBy(@Param("name") String name);

}
