/**
 * 
 */
package com.huaguo.admin.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.mybatis.extend.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.huaguo.admin.model.security.User;
import com.huaguo.admin.service.UserService;

/**
 * @author zhang jianxin
 * @date 2015
 */
@Controller
@RequestMapping("/security/user")
public class UserController {
	
	@Resource
	UserService userService;
	
	@RequestMapping(value="/list", method={RequestMethod.GET})
	public String list(Model model, WebRequest request) throws Exception {
		Pager pager = new Pager();
		String sPage = request.getParameter("page");
		if(StringUtils.isBlank(sPage)) {
			sPage = "1";
		}
		int page = Integer.parseInt(sPage);
		pager.setCurrentPageNo(page);
		String sPageSize = request.getParameter("rows");
		if(StringUtils.isNotBlank(sPageSize)) {
			pager.setPageSize(Integer.parseInt(sPageSize));
		}
		List<User> userList = userService.listByParam(null, pager);
		ObjectMapper objectMapper = new ObjectMapper();
		String userListJson = objectMapper.writeValueAsString(userList);
		model.addAttribute("userList", userListJson);
		return "security/user/list";
	}
	
	@RequestMapping(value="/get/{id}", method={RequestMethod.GET})
	public String get(Model model, @PathVariable("id") String id) {
		return "security/user/show";
	}
	
	@RequestMapping(value="/create", method={RequestMethod.GET})
	public String forCreate() {
		return "security/user/edit";
	}
	
	@RequestMapping(value="/modify/{id}", method={RequestMethod.GET})
	public String forModify(@PathVariable("id") String id) {
		return "security/user/edit";
	}
	
	@RequestMapping(value="/create", method={RequestMethod.POST})
	public void create() {
		User user = new User();
	}
	
	@RequestMapping(value="/modify", method={RequestMethod.POST})
	public void modify() {
		
	}
	
	@RequestMapping(value="/delete", method={RequestMethod.POST})
	public void delete() {
		
	}
	
}
