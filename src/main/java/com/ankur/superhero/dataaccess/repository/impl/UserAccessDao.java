package com.ankur.superhero.dataaccess.repository.impl;

import org.springframework.stereotype.Repository;

import com.ankur.superhero.dataaccess.entity.UserAccess;
import com.ankur.superhero.dataaccess.repository.UserAccessDaoService;

@Repository
public class UserAccessDao extends AbstractDao<UserAccess> 
									implements UserAccessDaoService {

	@Override
	protected Class<UserAccess> getEntityClass() {
		return UserAccess.class;
	}
}
