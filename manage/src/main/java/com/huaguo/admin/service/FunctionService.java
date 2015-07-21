/**
 * 
 */
package com.huaguo.admin.service;

import java.util.Collection;

import com.huaguo.admin.model.security.Function;
import com.huaguo.admin.model.security.Role;

/**
 * @author zhang jianxin
 * @date 2015
 */
public interface FunctionService {

	Collection<Function> listFunctionsByRoles(Collection<Role> roles);
}
