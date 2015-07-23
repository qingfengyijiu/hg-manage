/**
 * 
 */
package com.huaguo.admin.model.system;

import java.util.Set;
import java.util.TreeSet;

import com.huaguo.common.base.BaseEntity;

/**
 * @author zhang jianxin
 * @date 2015
 */
public class Menu extends BaseEntity implements Comparable<Object> {

	private static final long serialVersionUID = 5272492951848406219L;

	private String id;
	
	private String key;
	
	private String title;
	
	private String href;
	
	private int menuLevel;
	
	private Set<Menu> children = new TreeSet<Menu>();
	
	private Menu parent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	
	public int getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
	}

	public Set<Menu> getChildren() {
		return children;
	}

	public void setChildren(Set<Menu> children) {
		this.children = children;
	} 
	
	public void addChild(Menu menu) {
		this.children.add(menu);
	}
	
	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Menu) {
			Menu menu = (Menu)obj;
			return Integer.parseInt(this.key) - Integer.parseInt(menu.getKey());
		} else {
			throw new IllegalArgumentException();
		}
	}
	
}
