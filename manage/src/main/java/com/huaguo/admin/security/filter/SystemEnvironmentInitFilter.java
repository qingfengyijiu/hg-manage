/**
 * 
 */
package com.huaguo.admin.security.filter;

import java.io.IOException;
import java.util.TreeSet;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huaguo.admin.model.system.Menu;
import com.huaguo.admin.service.MenuService;

/**
 * @author zhang jianxin
 * @date 2015
 */
@Component("systemEnvironmentInitFilter")
public class SystemEnvironmentInitFilter extends GenericFilterBean {
	
	private static final String SYSTEM_NAV_DATA = "NAV_DATA";

	@Resource
	MenuService menuService;
	
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		boolean isAuthenticated = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
		if(isAuthenticated) {
			TreeSet<Menu> nav = this.menuService.tree();
			ObjectMapper objectMapper = new ObjectMapper();
			String navData = objectMapper.writeValueAsString(nav);
			request.getSession().setAttribute(SYSTEM_NAV_DATA, navData);
		}
		filterChain.doFilter(request, resp);
		
	}

}
