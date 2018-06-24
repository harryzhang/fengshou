/*
 * Powered By  huangzl QQ: 272950754
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2018
 */

package com.kder.business.service.commision;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kder.business.common.constant.Constants;
import com.kder.business.common.page.PageDo;
import com.kder.business.dao.commission.IOrderCommissionMapper;
import com.kder.business.entity.commission.OrderCommission;
import com.kder.business.entity.commission.OrderCommissionExample;
import com.kder.business.service.commission.IOrderCommissionService;

/**
 * @author  huangzl QQ: 272950754
 * @version 1.0
 * @since 1.0
 */


@Service("orderCommissionService")
public class OrderCommissionServiceImpl implements IOrderCommissionService {

	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
    private IOrderCommissionMapper  orderCommissionDao;
	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	@Override
	public OrderCommission getById(Long id){
	  return orderCommissionDao.selectByPrimaryKey(id);
	}
	
	/**
	 *根据条件查询列表
	 */
	@Override
	public List<OrderCommission> selectOrderCommission(OrderCommissionExample example){
		return orderCommissionDao.selectByExample(example);
	}
	
	
	
	/**
	 * 更新
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int updateOrderCommissionById(OrderCommission newOrderCommission){
		logger.debug("updateOrderCommission(OrderCommission: "+newOrderCommission);
		return  orderCommissionDao.updateByPrimaryKeySelective(newOrderCommission);		
	}
	
	/**
	 * 新增
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int addOrderCommission(OrderCommission newOrderCommission){
		logger.debug("addOrderCommission: "+newOrderCommission);
		return orderCommissionDao.insertSelective(newOrderCommission);
	}
	
	/**
	 * 分页查询
	 * @param param
	 * @param page
	 * @return
	 */
	public PageDo<OrderCommission> getOrderCommissionPage(Map<String, Object> param, PageDo<OrderCommission> page){
		logger.info("----getOrderCommissionPage----"+param);
        param.put(Constants.MYBATIS_PAGE, page);
        List<OrderCommission> list =  orderCommissionDao.queryListPage(param);
        page.setModelList(list);
        return page;
	}
	
	/**
	 * 删除
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int deleteById(Long id){
		logger.debug("deleteByIdOrderCommission:"+id);
		return  orderCommissionDao.deleteByPrimaryKey(id);		
	}

}
