/**
 * 
 */
package com.huaguo.admin.security.handler;

import java.io.IOException;
import java.util.Collection;
import java.util.TreeSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huaguo.admin.model.security.Role;
import com.huaguo.admin.model.system.Menu;
import com.huaguo.admin.service.MenuService;

/**
 * @author zhang jianxin
 * @date 2015
 */
@Component("authenticationSuccessHandler")
public class CustomAuthenticationSuccesshandler extends SavedRequestAwareAuthenticationSuccessHandler implements InitializingBean {

	private static final String SYSTEM_NAV_DATA = "NAV_DATA";
	
	
	@Resource
	MenuService menuService;
	
	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
		Collection<Role> roles = (Collection<Role>)authentication.getAuthorities();
		TreeSet<Menu> nav = this.menuService.tree();
		ObjectMapper objectMapper = new ObjectMapper();
		String navData = objectMapper.writeValueAsString(nav);
		request.getSession().setAttribute(SYSTEM_NAV_DATA, navData);
		super.onAuthenticationSuccess(request, response, authentication);
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		this.setDefaultTargetUrl("/home");
		this.setAlwaysUseDefaultTargetUrl(false);
	}

}
