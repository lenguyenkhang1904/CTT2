package com.example.CDTT2.Role.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Service;

import com.example.CDTT2.Genneric.GenericService;
import com.example.CDTT2.Genneric.MapModelToDto;
import com.example.CDTT2.Role.dto.SaveRoleDto;
import com.example.CDTT2.Role.model.Role;
import com.example.CDTT2.Role.repository.IRoleRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class RoleService extends GenericService<SaveRoleDto, Role, Long> implements IRoleService {

	private IRoleRepository iRoleRepository;
	
	private MapModelToDto mapModelToDto;
	
	@Override
	public Role save(SaveRoleDto dto) {

		try {
			Role role=new Role();
			
			role=(Role)mapModelToDto.mapper(dto, role);
			
			return iRoleRepository.save(role);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Role update(SaveRoleDto dto) {
		
		try {
			Role role=iRoleRepository.getOne(dto.getId());
			
			role=(Role)mapModelToDto.mapper(dto, role);
			
			return iRoleRepository.save(role);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
