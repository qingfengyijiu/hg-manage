/**
 * 
 */
package com.huaguo.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zhang jianxin
 * @date 2015
 */
@Controller
@RequestMapping("/security/role")
public class RoleController {

	@RequestMapping(value="/", method={RequestMethod.GET})
	public String home() {
		return "security/role/tree";
	}
	
	@RequestMapping(value="/create", method={RequestMethod.GET})
	public String forCreate() {
		return "security/role/edit";
	}
	
	@RequestMapping(value="/create", method={RequestMethod.POST})
	public void create() {
		
	}
	
	@RequestMapping(value="/modify", method={RequestMethod.GET})
	public String forModify() {
		return "security/role/edit";
	}
	
	@RequestMapping(value="/modify", method={RequestMethod.POST})
	public void modify() {
		
	}
	
	@RequestMapping(value="/delete", method={RequestMethod.POST})
	public void delete() {
		
	}
	
	
}
