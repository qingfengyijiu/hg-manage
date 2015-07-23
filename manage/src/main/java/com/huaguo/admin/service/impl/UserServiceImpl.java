/**
 * 
 */
package com.huaguo.admin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huaguo.admin.dao.NewUserMapper;
import com.huaguo.admin.model.security.User;
import com.huaguo.admin.service.UserService;
import com.huaguo.common.base.AbstractBaseService;
import com.huaguo.common.base.BaseMapper;

/**
 * @author zhang jianxin
 * @date 2015
 */
@Service("userService")
public class UserServiceImpl extends AbstractBaseService<User> implements UserService {
	
	@Resource
	NewUserMapper newUserMapper;

	/* (non-Javadoc)
	 * @see com.huaguo.common.base.AbstractBaseService#getMapper()
	 */
	@Override
	protected BaseMapper<User> getMapper() {
		return this.newUserMapper;
	}

	
}
