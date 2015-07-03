/**
 * 
 */
package com.huaguo.admin.service;

import java.util.Collection;

import com.huaguo.admin.model.Function;
import com.huaguo.admin.model.Role;

/**
 * @author zhang jianxin
 * @date 2015
 */
public interface FunctionService {

	Collection<Function> listFunctionsByRoles(Collection<Role> roles);
}
