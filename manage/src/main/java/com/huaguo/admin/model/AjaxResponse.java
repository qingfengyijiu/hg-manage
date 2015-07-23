/**
 * 
 */
package com.huaguo.admin.model;

import java.util.Map;

/**
 * @author zhang jianxin
 * @date 2015
 */
public class AjaxResponse {
	
	private boolean state;

	private Map<String, String> errors;

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
}
