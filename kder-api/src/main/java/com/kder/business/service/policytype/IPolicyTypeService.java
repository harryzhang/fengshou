/*
 * Powered By  huangzl QQ: 272950754
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2018
 */

package com.kder.business.service.policytype;

/**
 * @author  huangzl QQ: 272950754
 * @version 1.0
 * @since 1.0
 */

import java.util.List;
import java.util.Map;

import com.kder.business.common.page.PageDo;
import com.kder.business.entity.policytype.TPolicyType;
import com.kder.business.entity.policytype.TPolicyTypeExample;


public interface IPolicyTypeService{

	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	public TPolicyType getById(Long id);
	
	/**
	 *根据条件查询列表
	 */
	public List<TPolicyType> selectPolicyType(TPolicyTypeExample example);
	
	/**
	 * 更新
	 */
	public int  updatePolicyTypeById(TPolicyType newTPolicyType);
	
	/**
	 * 新增
	 */
	public int addPolicyType(TPolicyType newTPolicyType);
	
	/**
	 * 分页查询
	 * @param param
	 * @param page
	 * @return
	 */
	public PageDo<TPolicyType> getPolicyTypePage(Map<String, Object> param);
	
	
	/**
	 * 删除
	 */
	public int deleteById(Long id);
}
