package com.kder.business.service.privatecust;

import java.util.List;
import java.util.Map;

import com.kder.business.common.page.PageDo;
import com.kder.business.entity.privatecust.CtPrivateCustExample;
import com.kder.business.entity.privatecust.CtPrivateCust;

public interface IPrivateCustService {

	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	public CtPrivateCust getById(Long id);
	
	/**
	 *根据条件查询列表
	 */
	public List<CtPrivateCust> selectCtPrivateCust(CtPrivateCustExample example);
	
	/**
	 * 更新
	 */
	public int  updateCtPrivateCustById(CtPrivateCust newCtPrivateCustDo);
	
	/**
	 * 新增
	 */
	public int addCtPrivateCust(CtPrivateCust newCtPrivateCustDo);
	
	/**
	 * 分页查询
	 * @param param
	 * @param page
	 * @return
	 */
	public PageDo<CtPrivateCust> getPrivateCustPage(Map<String, Object> param, PageDo<CtPrivateCust> page);
	
	
	/**
	 * 删除
	 */
	public int deleteById(Long id);

}
