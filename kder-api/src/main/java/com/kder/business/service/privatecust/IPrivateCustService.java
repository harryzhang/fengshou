package com.kder.business.service.privatecust;

import java.util.List;
import java.util.Map;

import com.kder.business.common.page.PageDo;
import com.kder.business.entity.privatecust.CtPrivateCustExample;
import com.kder.business.entity.privatecust.PrivateCustDo;

public interface IPrivateCustService {

	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	public PrivateCustDo getById(Long id);
	
	/**
	 *根据条件查询列表
	 */
	public List<PrivateCustDo> selectCtPrivateCust(CtPrivateCustExample example);
	
	/**
	 * 更新
	 */
	public int  updateCtPrivateCustById(PrivateCustDo newCtPrivateCustDo);
	
	/**
	 * 新增
	 */
	public int addCtPrivateCust(PrivateCustDo newCtPrivateCustDo);
	
	/**
	 * 分页查询
	 * @param param
	 * @param page
	 * @return
	 */
	public PageDo<PrivateCustDo> getPrivateCustPage(Map<String, Object> param, PageDo<PrivateCustDo> page);
	
	
	/**
	 * 删除
	 */
	public int deleteById(Long id);

}
