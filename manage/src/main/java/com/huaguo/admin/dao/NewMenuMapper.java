/**
 * 
 */
package com.huaguo.admin.dao;

import com.huaguo.admin.model.system.Menu;
import com.huaguo.common.base.BaseMapper;

/**
 * @author zhang jianxin
 * @date 2015
 */
public interface NewMenuMapper extends BaseMapper<Menu> {
	
	void batchDelete(String ids);
	
	Menu selectParent(String id);

}
