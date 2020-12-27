package com.ankur.superhero.businesslogic.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ankur.superhero.businesslogic.mapper.UserDetailMapper;
import com.ankur.superhero.dataaccess.entity.UserAccess;
import com.ankur.superhero.dataaccess.repository.UserAccessDaoService;

@Service
public class ComicUserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserAccessDaoService repository;
	
	@Autowired
	private UserDetailMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		
		Optional<UserAccess> userAccess = repository.findByUsername(username);
		if (!userAccess.isPresent()) {
			throw new UsernameNotFoundException("User Not Found");
		}
		return mapper.mapEntityToUserDetail(userAccess.get());
	}
	
}
