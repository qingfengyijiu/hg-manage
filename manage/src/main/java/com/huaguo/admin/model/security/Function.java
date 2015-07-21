/**
 * 
 */
package com.huaguo.admin.model.security;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author zhang jianxin
 * @date 2015
 */
public class Function {
	
	public String id;
	
	public String path;
	
	public String desc;
	
	public Collection<Role> roles = new HashSet<Role>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

}
