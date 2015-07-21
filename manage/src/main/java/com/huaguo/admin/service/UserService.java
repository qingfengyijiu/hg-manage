/**
 * 
 */
package com.huaguo.admin.service;

import java.util.List;
import java.util.Map;

import org.mybatis.extend.Pager;

import com.huaguo.admin.model.security.User;

/**
 * @author zhang jianxin
 * @date 2015
 */
public interface UserService {

	public abstract List<User> listAll();
	
	public abstract List<User> listByParam(Map<String, Object> param);
	
	public abstract List<User> listByParam(Map<String, Object> param, Pager pager);

	public abstract int insert(User user);

	public abstract int update(User user);

	public abstract int delete(User user);

}