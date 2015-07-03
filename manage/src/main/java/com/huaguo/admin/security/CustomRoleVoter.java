/**
 * 
 */
package com.huaguo.admin.security;

import java.util.Collection;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;

import com.huaguo.admin.model.Function;
import com.huaguo.admin.model.Role;

/**
 * @author zhang jianxin
 * @date 2015
 */
public class CustomRoleVoter extends RoleVoter {
	
	private static final String ROLE_CUSTOM = "CUSTOM";

	@Override
	public int vote(Authentication authentication, Object object,
			Collection<ConfigAttribute> attributes) {
		boolean custom = false;
		for(ConfigAttribute attribute : attributes) {
			if(attribute.getAttribute().equals(this.getRolePrefix() + ROLE_CUSTOM)) {
				custom = true;
				break;
			}
		}
		if(!custom) {
			return super.vote(authentication, object, attributes);
		} else {
			int result = ACCESS_ABSTAIN;
			FilterInvocation fi = (FilterInvocation)object;
			HttpServletRequest request = fi.getRequest();
			String contextPath = request.getContextPath();
			String uri = request.getRequestURI();
			Collection<Function> functions = this.extractFunctions(authentication);
			if(functions != null && functions.size() > 0) {
				result = ACCESS_DENIED;
				for(Function function : functions) {
					if(uri.startsWith(function.getPath()) || (contextPath + uri).startsWith(function.getPath())) {
						return ACCESS_GRANTED;
					}
				}
			}
			return result;
		}
	}
	
	public Collection<Function> extractFunctions(Authentication authentication) {
		Collection<Function> functions = new HashSet<Function>();
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for(GrantedAuthority authority : authorities) {
			if(authority instanceof Role) {
				Role role = (Role)authority;
				functions.addAll(role.getFunctions());
			}
		}
		return functions;
	}
	
}
