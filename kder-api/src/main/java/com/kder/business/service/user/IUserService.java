package com.kder.business.service.user;

import java.util.List;

import com.kder.business.common.result.Result;
import com.kder.business.entity.user.People;
import com.kder.business.entity.user.PeopleExample;

public interface IUserService {

	int countByExample(PeopleExample example);

	
	int deleteByExample(PeopleExample example);

	
	int deleteByPrimaryKey(Integer peopleId);

	
	int insert(People record);

	
	int insertSelective(People record);

	List<People> selectByExample(PeopleExample example);

	
	People selectByPrimaryKey(Integer peopleId);

	
	int updateByExampleSelective(People record,PeopleExample example);

	
	int updateByExample(People record,PeopleExample example);

	
	int updateByPrimaryKeySelective(People record);

	
	int updateByPrimaryKey(People record);


	/**
	 * 用户注册
	 * @param userDo
	 * @return
	 */
	Result<?> reg(People userDo);
}
