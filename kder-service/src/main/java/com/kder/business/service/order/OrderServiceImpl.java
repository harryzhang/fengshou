/*
 * Powered By  huangzl QQ: 272950754
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2018
 */

package com.kder.business.service.order;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

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

	/**
	 * <option value="2">非车险</option>
	 * <option value="1">车险</option>
	 * <option value="3">寿险</option>
	 * 订单导入
	 */
	@Override
	public void importOrder(List<Map<String, Object>> sheetRows,
							String importFileName,
							String importType,
							Integer operatorId) {
		Assert.notEmpty(sheetRows, "不要导入空的excel");
		//导入记录
		Map<String,Object> importLog = new HashMap<String,Object>();
		String importId = UUID.randomUUID().toString();
		importLog.put("importId", importId);//导入批次号
		importLog.put("fileName", importFileName);
		importLog.put("userId", operatorId);//操作用户id
		importLog.put("importType", importType);//操作用户id
		ctOrderDao.insertImportLog(importLog);
		//导入明细
		for(Map<String,Object> oneRow : sheetRows){
			oneRow.put("Column_0", importId);
			ctOrderDao.importOrder(oneRow);
		}
		
		//处理没有维护的主数据
		if("1".equalsIgnoreCase(importType)){
			
		}else if("2".equalsIgnoreCase(importType)){
			
		}else if("3".equalsIgnoreCase(importType)){
			
		}
		
		//写正式表
		if("1".equalsIgnoreCase(importType)){
			insertOrderTabBybxxh1(importId,importType);
		}else if("2".equalsIgnoreCase(importType)){
			insertOrderTabBybxxh2(importId,importType);
		}else if("3".equalsIgnoreCase(importType)){
			insertOrderTabBybxxh3(importId,importType);
		}
	}

	private void insertOrderTabBybxxh3(String importId,String importType) {
		ctOrderDao.insertOrderTabBybxxh3(importId,importType);
	}

	private void insertOrderTabBybxxh2(String importId,String importType) {
		ctOrderDao.insertOrderTabBybxxh2(importId,importType);
	}

	private void insertOrderTabBybxxh1(String importId,String importType) {
		ctOrderDao.insertOrderTabBybxxh1(importId,importType);
	}

}
