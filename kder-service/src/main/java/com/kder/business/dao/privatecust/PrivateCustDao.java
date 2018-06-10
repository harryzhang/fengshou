package com.kder.business.dao.privatecust;

import com.kder.business.entity.privatecust.PrivateCustDo;


public interface PrivateCustDao {

	public int insertSelective(PrivateCustDo privateCust);
	
	public  PrivateCustDo  selectByPrimaryKey(Long privatecustId);

	
	public  int updateByPrimaryKeySelective(PrivateCustDo privateCust);
}
