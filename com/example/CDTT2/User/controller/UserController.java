package com.example.CDTT2.User.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CDTT2.Genneric.GenericController;
import com.example.CDTT2.User.Dto.SaveUserDto;
import com.example.CDTT2.User.model.User;

@RestController
@RequestMapping("/api/user")

public class UserController extends GenericController<SaveUserDto, User, Long, BindingResult> {

}
