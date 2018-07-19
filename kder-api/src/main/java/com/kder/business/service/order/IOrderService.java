/*
 * Powered By  huangzl QQ: 272950754
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2018
 */

package com.kder.business.service.order;

/**
 * @author  huangzl QQ: 272950754
 * @version 1.0
 * @since 1.0
 */

import java.util.List;
import java.util.Map;

import com.kder.business.common.page.PageDo;
import com.kder.business.entity.order.CtOrder;
import com.kder.business.entity.order.CtOrderExample;


public interface IOrderService{

	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	public CtOrder getById(Long id);
	
	/**
	 *根据条件查询列表
	 */
	public List<CtOrder> selectCtOrder(CtOrderExample example);
	
	/**
	 * 更新
	 */
	public int  updateCtOrderById(CtOrder newCtOrder);
	
	/**
	 * 新增
	 */
	public int addCtOrder(CtOrder newCtOrder);
	
	/**
	 * 分页查询
	 * @param param
	 * @param page
	 * @return
	 */
	public PageDo<CtOrder> getOrderPage(Map<String, Object> param);
	
	
	/**
	 * 删除
	 */
	public int deleteById(Long id);

	/**
	 * 导入
	 * @param sheetRows
	 */
	public void importOrder(List<Map<String, Object>> sheetRows,String importFileName,String importType,Integer operatorId);
}
