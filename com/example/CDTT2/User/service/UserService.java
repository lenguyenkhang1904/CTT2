package com.example.CDTT2.User.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.CDTT2.Genneric.GenericService;
import com.example.CDTT2.Genneric.MapModelToDto;
import com.example.CDTT2.Role.model.Role;
import com.example.CDTT2.Role.repository.IRoleRepository;
import com.example.CDTT2.User.Dto.SaveUserDto;
import com.example.CDTT2.User.model.User;
import com.example.CDTT2.User.repository.IUserRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserService extends GenericService<SaveUserDto, User, Long> implements IUserService {

	private IUserRepository iUserRepository;

	private IRoleRepository iRoleRepository;

	private MapModelToDto mapModelToDto;
	
	private PasswordEncoder passwordEncoder;

	@Override
	public User save(SaveUserDto dto) {
		try {
			User user = new User();

			user = (User) mapModelToDto.mapper(dto, user);
			
			user.setPassword(passwordEncoder.encode(dto.getPassword()));

			if (findAll().isEmpty()) {

				// nếu rỗng tạo admin-role
				String nameRole = "admin-role";

				Role role = new Role().addRoleName(nameRole);

				iRoleRepository.save(role);

				Set<Role> roles = user.getRoles();
				Role roleAdmin = iRoleRepository.findByRoleNameBy(nameRole);
				roles.add(roleAdmin);

				user.setRoles(roles);
				return iUserRepository.save(user);
			}

			Set<Long> listRoleId = dto.getIdRole();

			Set<Role> roles = new HashSet<>();

			for (Long i : listRoleId) {
				Role role = iRoleRepository.getOne(i);
				roles.add(role);
			}
			user.setRoles(roles);
			
			
			

			return iUserRepository.save(user);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public User update(SaveUserDto dto) {

		try {
			User user = iUserRepository.getOne(dto.getId());

			user = (User) mapModelToDto.mapper(dto, user);

			Set<Long> listRoleId = dto.getIdRole();

			Set<Role> roles = new HashSet<>();

			for (Long i : listRoleId) {
				Role role = iRoleRepository.getOne(i);
				roles.add(role);
			}
			user.setRoles(roles);

			return iUserRepository.save(user);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}
}
