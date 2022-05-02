package com.example.CDTT2.User.service;

import com.example.CDTT2.Genneric.IGenericService;
import com.example.CDTT2.Role.dto.SaveRoleDto;
import com.example.CDTT2.User.Dto.SaveUserDto;
import com.example.CDTT2.User.model.User;

public interface IUserService extends IGenericService<SaveUserDto, User, Long> {

}
