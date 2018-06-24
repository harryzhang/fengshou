/*
 * Powered By  huangzl QQ: 272950754
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2018
 */

package com.kder.business.service.privatecust;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kder.business.common.constant.Constants;
import com.kder.business.common.page.PageDo;
import com.kder.business.dao.privatecust.PrivateCustDao;
import com.kder.business.entity.privatecust.CtPrivateCustExample;
import com.kder.business.entity.privatecust.PrivateCustDo;

/**
 * @author  huangzl QQ: 272950754
 * @version 1.0
 * @since 1.0
 */


@Service("privateCustService")
public class PrivateCustServiceImpl implements IPrivateCustService {

	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
    private PrivateCustDao  ctPrivateCustDao;
	
	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	@Override
	public PrivateCustDo getById(Long id){
	  return ctPrivateCustDao.selectByPrimaryKey(id);
	}
	
	/**
	 *根据条件查询列表
	 */
	@Override
	public List<PrivateCustDo> selectCtPrivateCust(CtPrivateCustExample example){
		return ctPrivateCustDao.selectByExample(example);
	}
	
	
	
	/**
	 * 更新
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int updateCtPrivateCustById(PrivateCustDo newCtPrivateCustDo){
		logger.debug("updateCtPrivateCust(PrivateCustDo: "+newCtPrivateCustDo);
		return  ctPrivateCustDao.updateByPrimaryKeySelective(newCtPrivateCustDo);		
	}
	
	/**
	 * 新增
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int addCtPrivateCust(PrivateCustDo newCtPrivateCustDo){
		logger.debug("addCtPrivateCust: "+newCtPrivateCustDo);
		return ctPrivateCustDao.insertSelective(newCtPrivateCustDo);
	}
	
	/**
	 * 分页查询
	 * @param param
	 * @param page
	 * @return
	 */
	public PageDo<PrivateCustDo> getPrivateCustPage(Map<String, Object> param, PageDo<PrivateCustDo> page){
		logger.info("----getCtPrivateCustPage----"+param);
        param.put(Constants.MYBATIS_PAGE, page);
        List<PrivateCustDo> list =  ctPrivateCustDao.queryListPage(param);
        page.setModelList(list);
        return page;
	}
	
	
	/**
	 * 删除
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int deleteById(Long id){
		logger.debug("deleteByIdCtPrivateCust:"+id);
		return  ctPrivateCustDao.deleteByPrimaryKey(id);		
	}

}
