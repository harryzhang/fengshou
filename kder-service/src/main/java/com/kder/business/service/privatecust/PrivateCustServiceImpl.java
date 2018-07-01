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
import com.kder.business.dao.privatecust.CtPrivateCustMapper;
import com.kder.business.entity.privatecust.CtPrivateCust;
import com.kder.business.entity.privatecust.CtPrivateCustExample;

/**
 * @author  huangzl QQ: 272950754
 * @version 1.0
 * @since 1.0
 */


@Service("privateCustService")
public class PrivateCustServiceImpl implements IPrivateCustService {

	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
    private CtPrivateCustMapper  ctPrivateCustDao;
	
	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	@Override
	public CtPrivateCust getById(Long id){
	  return ctPrivateCustDao.selectByPrimaryKey(id);
	}
	
	/**
	 *根据条件查询列表
	 */
	@Override
	public List<CtPrivateCust> selectCtPrivateCust(CtPrivateCustExample example){
		return ctPrivateCustDao.selectByExample(example);
	}
	
	
	
	/**
	 * 更新
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int updateCtPrivateCustById(CtPrivateCust newCtPrivateCustDo){
		logger.debug("updateCtPrivateCust(PrivateCustDo: "+newCtPrivateCustDo);
		return  ctPrivateCustDao.updateByPrimaryKeySelective(newCtPrivateCustDo);		
	}
	
	/**
	 * 新增
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int addCtPrivateCust(CtPrivateCust newCtPrivateCustDo){
		logger.debug("addCtPrivateCust: "+newCtPrivateCustDo);
		return ctPrivateCustDao.insertSelective(newCtPrivateCustDo);
	}
	
	/**
	 * 分页查询
	 * @param param
	 * @param page
	 * @return
	 */
	public PageDo<CtPrivateCust> getPrivateCustPage(Map<String, Object> param, PageDo<CtPrivateCust> page){
		logger.info("----getCtPrivateCustPage----"+param);
        param.put(Constants.MYBATIS_PAGE, page);
        List<CtPrivateCust> list =  ctPrivateCustDao.queryListPage(param);
        page.setDatas(list);
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
