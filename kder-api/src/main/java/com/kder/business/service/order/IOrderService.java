package com.kder.business.service.order;

import java.util.List;

import com.kder.business.entity.order.CtOrder;
import com.kder.business.entity.order.CtOrderExample;

public interface IOrderService {
	
    int countByExample(CtOrderExample example);

    int deleteByExample(CtOrderExample example);

    int deleteByPrimaryKey(Long orderId);

    int insertSelective(CtOrder record);

    List<CtOrder> selectByExample(CtOrderExample example);

    CtOrder selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(CtOrder record, CtOrderExample example);


    int updateByPrimaryKeySelective(CtOrder record);
    

}
