package com.ankur.superhero.businesslogic.service.mapper;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.ankur.superhero.dataaccess.entity.UserAccess;

@SuppressWarnings("serial")
@Component
public class UserDetailMapper {

	public UserDetails mapEntityToUserDetail(UserAccess userAccess) {

		return new UserDetails() {

			@Override
			public boolean isEnabled() {
				return true;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}

			@Override
			public boolean isAccountNonLocked() {
				return true;
			}

			@Override
			public boolean isAccountNonExpired() {
				return true;
			}

			@Override
			public String getUsername() {
				return userAccess.getUser();
			}

			@Override
			public String getPassword() {
				return userAccess.getPassword();
			}

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				return userAccess.getUserRoles().stream()
								.map(role -> new SimpleGrantedAuthority(role.getRole()))
								.collect(Collectors.toList());
			}
		};
	}
}
