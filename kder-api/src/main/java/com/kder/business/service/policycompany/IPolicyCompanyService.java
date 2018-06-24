/*
 * Powered By  huangzl QQ: 272950754
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2018
 */

package com.kder.business.service.policycompany;

/**
 * @author  huangzl QQ: 272950754
 * @version 1.0
 * @since 1.0
 */

import java.util.List;
import java.util.Map;

import com.kder.business.common.page.PageDo;
import com.kder.business.entity.policycompany.PolicyCompanyDo;
import com.kder.business.entity.policycompany.PolicyCompanyExample;


public interface IPolicyCompanyService{

	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	public PolicyCompanyDo getById(Long id);
	
	/**
	 *根据条件查询列表
	 */
	public List<PolicyCompanyDo> selectPolicyCompany(PolicyCompanyExample example);
	
	/**
	 * 更新
	 */
	public int  updatePolicyCompanyById(PolicyCompanyDo newPolicyCompanyDo);
	
	/**
	 * 新增
	 */
	public int addPolicyCompany(PolicyCompanyDo newPolicyCompanyDo);
	
	/**
	 * 删除
	 */
	public int deleteById(Long id);

	/**
	 * 分页查询
	 * @param param
	 * @param page
	 * @return
	 */
	public PageDo<PolicyCompanyDo> getPolicyCompanyPage(Map<String, Object> param, PageDo<PolicyCompanyDo> page);
}
