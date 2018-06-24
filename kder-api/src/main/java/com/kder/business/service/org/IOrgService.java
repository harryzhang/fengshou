/*
 * Powered By  huangzl QQ: 272950754
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2018
 */

package com.kder.business.service.org;

/**
 * @author  huangzl QQ: 272950754
 * @version 1.0
 * @since 1.0
 */

import java.util.List;
import java.util.Map;

import com.kder.business.common.page.PageDo;
import com.kder.business.entity.org.OrgDo;
import com.kder.business.entity.org.OrgExample;


public interface IOrgService{

	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	public OrgDo getById(Long id);
	
	/**
	 *根据条件查询列表
	 */
	public List<OrgDo> selectOrg(OrgExample example);
	
	/**
	 * 更新
	 */
	public int  updateOrgById(OrgDo newOrgDo);
	
	/**
	 * 新增
	 */
	public int addOrg(OrgDo newOrgDo);
	
	/**
	 * 分页查询
	 * @param param
	 * @param page
	 * @return
	 */
	public PageDo<OrgDo> getOrgPage(Map<String, Object> param, PageDo<OrgDo> page);
	
	
	/**
	 * 删除
	 */
	public int deleteById(Long id);
}
