/**
 * 
 */
package com.huaguo.admin.controller.system;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
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
	public String tree(Model model) throws Exception {
		TreeSet<Menu> menuTree = this.menuService.tree();
		List<FancyTreeNode> menuFancyTree = new ArrayList<FancyTreeNode>();
		for(Menu menu : menuTree) {
			menuFancyTree.add(menu.translate2FancyTree());
		}
		ObjectMapper objectMapper = new ObjectMapper();
		String menuFancyTreeJson = objectMapper.writeValueAsString(menuFancyTree);
		model.addAttribute("menuFancyTreeJson", menuFancyTreeJson);
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
		return "system/menu/create";
	}
	
	@RequestMapping(value="/modify/{id}", method={RequestMethod.GET})
	public String forModify(Model model, @PathVariable String id) {
		Menu menu = this.menuService.select(id);
		Menu parent = this.menuService.selectParent(id);
		menu.setParent(parent);
		model.addAttribute("menu", menu);
		List<Menu> abstractMenuList = this.menuService.listAbstractMenu();
		model.addAttribute("abstractMenuList", abstractMenuList);
		return "system/menu/modify";
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
	
	@ResponseBody
	@RequestMapping(value="/modify/do", method={RequestMethod.POST}, consumes={"application/json"})
	public AjaxResponse modify(Model model, @RequestBody Menu menu) {
		this.menuService.update(menu);
		return new AjaxResponse();
	}
	
	@ResponseBody
	@RequestMapping(value="/delete", method={RequestMethod.POST})
	public AjaxResponse delete(WebRequest request) {
		String id = request.getParameter("id");
		Menu menu = this.menuService.select(id);
		if(menu.getChildren().size() == 0) {
			this.menuService.delete(id);
		} else {
			List<String> deleteIds = new ArrayList<String>();
			_delete(menu, deleteIds);
			String ids = this._generateIdStr(deleteIds);
			this.menuService.batchDelete(ids);
		}
		return new AjaxResponse();
	}
	
	private void _delete(Menu menu, List<String> deleteIds) {
		deleteIds.add(menu.getId());
		for(Menu child : menu.getChildren()) {
			_delete(child, deleteIds);
		}
	}
	
	private String _generateIdStr(List<String> idList) {
		StringBuffer idStr = new StringBuffer();
		idStr.append("(");
		for(String id : idList) {
			idStr.append("'");
			idStr.append(id);
			idStr.append("'");
			idStr.append(",");
		}
		idStr.deleteCharAt(idStr.length() - 1);
		idStr.append(")");
		return idStr.toString();
	}
	
	@RequestMapping(value="/delete/batch")
	public void batchDelete() {
		
	}
}
