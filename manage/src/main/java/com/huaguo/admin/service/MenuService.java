/**
 * 
 */
package com.huaguo.admin.service;

import java.util.List;
import java.util.TreeSet;

import com.huaguo.admin.model.system.Menu;
import com.huaguo.common.base.IBaseService;

/**
 * @author zhang jianxin
 * @date 2015
 */
public interface MenuService extends IBaseService<Menu> {

	TreeSet<Menu> treeAll();
	
	List<Menu> listAbstractMenu();
}
