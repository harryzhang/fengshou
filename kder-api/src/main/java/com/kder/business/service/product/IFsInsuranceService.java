/*
 * Powered By  huangzl QQ: 272950754
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2018
 */

package com.kder.business.service.product;

/**
 * @author  huangzl QQ: 272950754
 * @version 1.0
 * @since 1.0
 */

import java.util.List;
import java.util.Map;

import com.kder.business.common.page.PageDo;
import com.kder.business.entity.product.TFsInsuranceExample;
import com.kder.business.entity.product.TFsInsuranceWithBLOBs;


public interface IFsInsuranceService{

	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	public TFsInsuranceWithBLOBs getById(Long id);
	
	/**
	 *根据条件查询列表
	 */
	public List<TFsInsuranceWithBLOBs> selectFsInsurance(TFsInsuranceExample example);
	
	/**
	 * 更新
	 */
	public int  updateFsInsuranceById(TFsInsuranceWithBLOBs newTFsInsuranceWithBLOBs);
	
	/**
	 * 新增
	 */
	public int addFsInsurance(TFsInsuranceWithBLOBs newTFsInsuranceWithBLOBs);
	
	/**
	 * 分页查询
	 * @param param
	 * @param page
	 * @return
	 */
	public PageDo<TFsInsuranceWithBLOBs> getFsInsurancePage(Map<String, Object> param, PageDo<TFsInsuranceWithBLOBs> page);
	
	
	/**
	 * 删除
	 */
	public int deleteById(Long id);
}
