/**
 * 
 */
package com.huaguo.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaguo.common.model.FancyTreeNode;

/**
 * @author zhang jianxin
 * @date 2015
 */
@Controller
@RequestMapping(value="/system/menu")
public class MenuController {

	@RequestMapping(value="/", method={RequestMethod.GET})
	public String home() {
		return "system/menu/tree";
	}
	
	@ResponseBody
	@RequestMapping(value="/data", method={RequestMethod.GET})
	public List<FancyTreeNode> data() {
		return null;
	}
	
	@RequestMapping(value="/create", method={RequestMethod.GET})
	public String forCreate() {
		return "system/menu/edit";
	}
	
	@RequestMapping(value="/modify", method={RequestMethod.GET})
	public String forModify() {
		return "system/menu/edit";
	}
	
	@RequestMapping(value="/create", method={RequestMethod.POST})
	public void create() {
		
	}
	
	@RequestMapping(value="/modify", method={RequestMethod.POST})
	public void rename() {
		
	}
	
	@RequestMapping(value="/delete", method={RequestMethod.POST})
	public void delete() {
		
	}
}
