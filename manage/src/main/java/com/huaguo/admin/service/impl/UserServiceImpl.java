/**
 * 
 */
package com.huaguo.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.extend.Pager;
import org.springframework.stereotype.Service;

import com.huaguo.admin.dao.NewUserMapper;
import com.huaguo.admin.model.security.User;
import com.huaguo.admin.service.UserService;

/**
 * @author zhang jianxin
 * @date 2015
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	NewUserMapper newUserMapper;

	/* (non-Javadoc)
	 * @see com.huaguo.admin.service.impl.UserService#listAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<User> listAll() {
		return newUserMapper.listByParam(null);
	}
	
	/* (non-Javadoc)
	 * @see com.huaguo.admin.service.impl.UserService#insert(com.huaguo.admin.model.security.User)
	 */
	@Override
	public int insert(User user) {
		return newUserMapper.insert(user);
	}
	
	/* (non-Javadoc)
	 * @see com.huaguo.admin.service.impl.UserService#update(com.huaguo.admin.model.security.User)
	 */
	@Override
	public int update(User user) {
		return newUserMapper.insert(user);
	}
	
	/* (non-Javadoc)
	 * @see com.huaguo.admin.service.impl.UserService#delete(com.huaguo.admin.model.security.User)
	 */
	@Override
	public int delete(User user) {
		return newUserMapper.delete(user);
	}

	/* (non-Javadoc)
	 * @see com.huaguo.admin.service.UserService#listByParam(java.util.Map)
	 */
	@Override
	public List<User> listByParam(Map<String, Object> param) {
		return newUserMapper.listByParam(param);
	}

	/* (non-Javadoc)
	 * @see com.huaguo.admin.service.UserService#listByParam(java.util.Map, org.mybatis.extend.Pager)
	 */
	@Override
	public List<User> listByParam(Map<String, Object> param, Pager pager) {
		return newUserMapper.listByParam(param, pager);
	}
	
}
