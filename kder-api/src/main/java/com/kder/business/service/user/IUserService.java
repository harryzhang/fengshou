package com.kder.business.service.user;

import java.util.List;
import java.util.Map;

import com.kder.business.common.page.PageDo;
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


	/**
	 * 分页查询
	 * @param param
	 * @param page
	 * @return
	 */
	PageDo<People> getPeoplePage(Map<String, Object> param, PageDo<People> page);
}
