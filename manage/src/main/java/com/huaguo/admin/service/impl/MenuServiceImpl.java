/**
 * 
 */
package com.huaguo.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.annotation.Resource;





import org.springframework.stereotype.Service;

import com.huaguo.admin.dao.NewMenuMapper;
import com.huaguo.admin.model.system.Menu;
import com.huaguo.admin.service.MenuService;
import com.huaguo.common.base.AbstractBaseService;
import com.huaguo.common.base.BaseMapper;

/**
 * @author zhang jianxin
 * @date 2015
 */
@Service("menuService")
public class MenuServiceImpl extends AbstractBaseService<Menu> implements MenuService {
	
	@Resource
	NewMenuMapper newMenuMapper;

	/* (non-Javadoc)
	 * @see com.huaguo.common.base.AbstractBaseService#getMapper()
	 */
	@Override
	protected BaseMapper<Menu> getMapper() {
		return this.newMenuMapper;
	}

	/* (non-Javadoc)
	 * @see com.huaguo.admin.service.MenuService#treeAll()
	 */
	@Override
	public TreeSet<Menu> treeAll() {
		List<Menu> menuList = this.listAll();
		TreeSet<Menu> menuTree = new TreeSet<Menu>();
		for(Menu menu : menuList) {
			menuTree.add(menu);
		}
		return menuTree;
	}

	/* (non-Javadoc)
	 * @see com.huaguo.admin.service.MenuService#listAbstractMenu()
	 */
	@Override
	public List<Menu> listAbstractMenu() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("href", "#");
		return this.listByParam(param);
	}



}
