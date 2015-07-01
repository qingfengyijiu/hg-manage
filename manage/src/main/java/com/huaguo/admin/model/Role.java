/**
 * 
 */
package com.huaguo.admin.model;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author zhang jianxin
 * @date 2015
 */
public class Role implements GrantedAuthority {
	
	private static final long serialVersionUID = 3306229594242095272L;

	private String id;
	
	//角色名称
	private String authority;
	
	private boolean buildIn;
	
	private String desc;
	
	private Collection<Function> functions = new HashSet<Function>();
	
	private Collection<User> users = new HashSet<User>();
	
	//是否排他
	private boolean mutex;
	
	public Role() {
		
	}
	
	public Role(String authority) {
		this.authority = authority;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isBuildIn() {
		return buildIn;
	}

	public void setBuildIn(boolean buildIn) {
		this.buildIn = buildIn;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Collection<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(Collection<Function> functions) {
		this.functions = functions;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public boolean isMutex() {
		return mutex;
	}

	public void setMutex(boolean mutex) {
		this.mutex = mutex;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.GrantedAuthority#getAuthority()
	 */
	@Override
	public String getAuthority() {
		return this.authority;
	}

}
