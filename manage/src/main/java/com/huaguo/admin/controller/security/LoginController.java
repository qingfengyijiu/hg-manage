package com.huaguo.admin.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zhang jianxin
 * @date 2015
 */
@Controller
public class LoginController {

	@RequestMapping(method={RequestMethod.GET}, value="/login")
	public String accessLogin() {
		return "login/login";
	}
	
	@RequestMapping(method={RequestMethod.GET}, value="/home")
	public String home() {
		return "home";
	}
	
}
