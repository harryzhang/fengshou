/*
 * Powered By  huangzl QQ: 272950754
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2018
 */

package com.kder.business.service.commission;

/**
 * @author  huangzl QQ: 272950754
 * @version 1.0
 * @since 1.0
 */

import java.util.List;
import java.util.Map;

import com.kder.business.common.page.PageDo;
import com.kder.business.entity.commission.OrderCommission;
import com.kder.business.entity.commission.OrderCommissionExample;


public interface IOrderCommissionService{

	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	public OrderCommission getById(Long id);
	
	/**
	 *根据条件查询列表
	 */
	public List<OrderCommission> selectOrderCommission(OrderCommissionExample example);
	
	/**
	 * 更新
	 */
	public int  updateOrderCommissionById(OrderCommission newOrderCommission);
	
	/**
	 * 新增
	 */
	public int addOrderCommission(OrderCommission newOrderCommission);
	
	/**
	 * 分页查询
	 * @param param
	 * @param page
	 * @return
	 */
	public PageDo<OrderCommission> getOrderCommissionPage(Map<String, Object> param, PageDo<OrderCommission> page);
	
	
	/**
	 * 删除
	 */
	public int deleteById(Long id);
}
