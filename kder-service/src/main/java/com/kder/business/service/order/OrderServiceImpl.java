package com.kder.business.service.order;

import java.util.List;

import javax.annotation.Resource;

import com.kder.business.dao.order.CtOrderMapper;
import com.kder.business.entity.order.CtOrder;
import com.kder.business.entity.order.CtOrderExample;

public class OrderServiceImpl  implements IOrderService{
	
	@Resource
	CtOrderMapper orderDao;

	@Override
	public int countByExample(CtOrderExample example) {
		return orderDao.countByExample(example);
	}

	@Override
	public int deleteByExample(CtOrderExample example) {
		return orderDao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long orderId) {
		return orderDao.deleteByPrimaryKey(orderId);
	}

	@Override
	public int insertSelective(CtOrder record) {
		return orderDao.insertSelective(record);
	}

	@Override
	public List<CtOrder> selectByExample(CtOrderExample example) {
		return orderDao.selectByExample(example);
	}

	@Override
	public CtOrder selectByPrimaryKey(Long orderId) {
		return orderDao.selectByPrimaryKey(orderId);
	}

	@Override
	public int updateByExampleSelective(CtOrder record, CtOrderExample example) {
		return orderDao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(CtOrder record) {
		return orderDao.updateByPrimaryKeySelective(record);
	}

}
