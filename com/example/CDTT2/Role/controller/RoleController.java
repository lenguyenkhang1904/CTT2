package com.example.CDTT2.Role.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CDTT2.Genneric.GenericController;
import com.example.CDTT2.Role.dto.SaveRoleDto;
import com.example.CDTT2.Role.model.Role;

@RestController
@RequestMapping("/api/role")
public class RoleController extends GenericController<SaveRoleDto, Role, Long, BindingResult> {

}
