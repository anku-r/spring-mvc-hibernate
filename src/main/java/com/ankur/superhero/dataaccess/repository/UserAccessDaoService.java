package com.ankur.superhero.dataaccess.repository;

import java.util.Optional;

import com.ankur.superhero.dataaccess.entity.UserAccess;

public interface UserAccessDaoService extends AbstractDaoService<UserAccess> {

	public Optional<UserAccess> findByUsername(String userName);
}
