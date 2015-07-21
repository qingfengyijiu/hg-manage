/**
 * 
 */
package com.huaguo.admin.model.system;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author zhang jianxin
 * @date 2015
 */
public class Menu implements Comparable<Object> {

	private String id;
	
	private String title;
	
	private String href;
	
	private Set<Menu> children = new TreeSet<Menu>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Set<Menu> getChildren() {
		return children;
	}

	public void setChildren(Set<Menu> children) {
		this.children = children;
	} 
	
	public void addChild(Menu menu) {
		this.children.add(menu);
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Menu) {
			Menu menu = (Menu)obj;
			return Integer.parseInt(this.id) - Integer.parseInt(menu.getId());
		} else {
			throw new IllegalArgumentException();
		}
	}
	
}
