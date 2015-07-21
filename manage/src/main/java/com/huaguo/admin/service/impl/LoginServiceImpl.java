/**
 * 
 */
package com.huaguo.admin.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.huaguo.admin.model.security.Role;
import com.huaguo.admin.model.security.User;
import com.huaguo.admin.service.LoginService;

/**
 * @author zhang jianxin
 * @date 2015
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = new User();
		user.setUsername("test");
		String password = "test";
		password = new BCryptPasswordEncoder().encode(password);
		user.setPassword(password);
		Set<Role> roles = new HashSet<Role>();
		roles.add(new Role("ROLE_TEST"));
		user.setAuthorities(roles);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		return user;
	}

}
