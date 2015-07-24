/**
 * 
 */
package com.huaguo.admin.model.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.huaguo.common.base.BaseEntity;
import com.huaguo.common.model.FancyTreeNode;

/**
 * @author zhang jianxin
 * @date 2015
 */
public class Menu extends BaseEntity implements Comparable<Object> {
	
	private static final boolean DEFAULT_EXPANDED = true;

	private static final long serialVersionUID = 5272492951848406219L;

	private String id;
	
	private String key;
	
	private String title;
	
	private String href;
	
	private int menuLevel;
	
	private TreeSet<Menu> children = new TreeSet<Menu>();
	
	private Menu parent;
	
	private String description;

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

	public void setChildren(TreeSet<Menu> children) {
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
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
	
	public FancyTreeNode translate2FancyTree() {
		FancyTreeNode node = new FancyTreeNode();
		node.setKey(this.getId());
		node.setHref(this.getHref());
		boolean isFolder = this.getChildren().size() > 0;
		node.setFolder(isFolder);
		node.setLazy(false);
		node.setExpanded(DEFAULT_EXPANDED);
		node.setTitle(this.getTitle());
		node.setTooltip(this.getDescription());
		List<FancyTreeNode> childrenNodes = new ArrayList<FancyTreeNode>();
		for(Menu child : this.getChildren()) {
			FancyTreeNode temp = child.translate2FancyTree();
			childrenNodes.add(temp);
		}
		node.setChildren(childrenNodes);
		return node;
	}
	
}
