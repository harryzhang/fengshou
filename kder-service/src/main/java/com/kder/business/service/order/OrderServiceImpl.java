/*
 * Powered By  huangzl QQ: 272950754
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2018
 */

package com.kder.business.service.order;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kder.business.common.constant.Constants;
import com.kder.business.common.page.PageDo;
import com.kder.business.common.util.DateUtil;
import com.kder.business.common.util.StringUtil;
import com.kder.business.dao.order.CtOrderMapper;
import com.kder.business.entity.order.CtOrder;
import com.kder.business.entity.order.CtOrderExample;

/**
 * @author  huangzl QQ: 272950754
 * @version 1.0
 * @since 1.0
 */


@Service("orderService")
public class OrderServiceImpl implements IOrderService {

	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
    private CtOrderMapper  ctOrderDao;
	
	
	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	@Override
	public CtOrder getById(Long id){
	  return ctOrderDao.selectByPrimaryKey(id);
	}
	
	/**
	 *根据条件查询列表
	 */
	@Override
	public List<CtOrder> selectCtOrder(CtOrderExample example){
		return ctOrderDao.selectByExample(example);
	}
	
	
	
	/**
	 * 更新
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int updateCtOrderById(CtOrder newCtOrder){
		logger.debug("updateCtOrder(CtOrder: "+newCtOrder);
		return  ctOrderDao.updateByPrimaryKeySelective(newCtOrder);		
	}
	
	/**
	 * 新增
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int addCtOrder(CtOrder newCtOrder){
		logger.debug("addCtOrder: "+newCtOrder);
		if(StringUtils.isBlank(newCtOrder.getOrderNo())){
			Random random = new Random();
			String no = StringUtil.fullString(5, random.nextInt(10));
			String userId = StringUtil.fullString(8,newCtOrder.getUserId().intValue());
			newCtOrder.setOrderNo("B"+DateUtil.YYYY_MM_DD.format(new Date())+userId+no);
		}
		if(null == newCtOrder.getOrderStatus()){
			newCtOrder.setOrderStatus(1);
		}
		newCtOrder.setCreateTime(new Date());
		return ctOrderDao.insertSelective(newCtOrder);
	}
	
	/**
	 * 分页查询
	 * @param param
	 * @param page
	 * @return
	 */
	public PageDo<CtOrder> getOrderPage(Map<String, Object> param){
		logger.info("----getCtOrderPage----"+param);
		PageDo page = (PageDo)param.get(Constants.MYBATIS_PAGE);
        List<CtOrder> list =  ctOrderDao.queryListPage(param);
        if(null == page){
        	page = new PageDo<CtOrder>();
        }
        page.setDatas(list);
        return page;
	}
	
	/**
	 * 删除
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int deleteById(Long id){
		logger.debug("deleteByIdCtOrder:"+id);
		return  ctOrderDao.deleteByPrimaryKey(id);		
	}

}
