/**
 * 
 */
package com.huaguo.admin.dao;

import com.huaguo.admin.model.security.User;
import com.huaguo.common.base.IListMapper;

/**
 * @author zhang jianxin
 * @date 2015
 */
public interface NewUserMapper extends IListMapper {

	
	int insert(User user);
	
	int update(User user);
	
	int delete(User user);
}
