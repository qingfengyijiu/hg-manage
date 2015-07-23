/**
 * 
 */
package com.huaguo.admin.controller.system;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaguo.admin.model.AjaxResponse;
import com.huaguo.admin.model.system.Menu;
import com.huaguo.admin.service.MenuService;
import com.huaguo.common.model.FancyTreeNode;
import com.huaguo.common.utils.UUID;

/**
 * @author zhang jianxin
 * @date 2015
 */
@Controller
@RequestMapping(value="/system/menu")
public class MenuController {
	
	@Resource
	MenuService menuService;

	@RequestMapping(value="", method={RequestMethod.GET})
	public String home(Model model) {
		TreeSet<Menu> menuTree = this.menuService.treeAll();
		model.addAttribute("menuTree", menuTree);
		return "system/menu/tree";
	}
	
	@ResponseBody
	@RequestMapping(value="/data", method={RequestMethod.GET})
	public List<FancyTreeNode> data() {
		return null;
	}
	
	@RequestMapping(value="/create", method={RequestMethod.GET})
	public String forCreate(Model model) {
		Menu menu = new Menu();
		model.addAttribute("menu", menu);
		List<Menu> abstractMenuList = this.menuService.listAbstractMenu();
		model.addAttribute("abstractMenuList", abstractMenuList);
		return "system/menu/edit";
	}
	
	@RequestMapping(value="/modify/{id}", method={RequestMethod.GET})
	public String forModify(Model model, @PathVariable String id) {
		Menu menu = this.menuService.select(id);
		model.addAttribute("menu", menu);
		return "system/menu/edit";
	}
	
	@ResponseBody
	@RequestMapping(value="/create/do", method={RequestMethod.POST})
	public AjaxResponse create(Model model, @RequestBody Menu menu) {
		String id = UUID.generateId();
		menu.setId(id);
		this.menuService.insert(menu);
		AjaxResponse ajaxResponse = new AjaxResponse();
		return ajaxResponse;
	}
	
	@RequestMapping(value="/modify", method={RequestMethod.POST}, consumes={"application/json"})
	public void modify(Model model, Menu menu) {
		this.menuService.update(menu);
	}
	
	@RequestMapping(value="/delete/{id}", method={RequestMethod.POST})
	public void delete(@PathVariable String id) {
		
	}
	
	@RequestMapping(value="/delete/batch")
	public void batchDelete() {
		
	}
}
