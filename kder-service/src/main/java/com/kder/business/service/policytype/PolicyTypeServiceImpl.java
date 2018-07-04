/*
 * Powered By  huangzl QQ: 272950754
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2018
 */

package com.kder.business.service.policytype;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kder.business.common.constant.Constants;
import com.kder.business.common.page.PageDo;
import com.kder.business.dao.policytype.TPolicyTypeMapper;
import com.kder.business.entity.policytype.TPolicyType;
import com.kder.business.entity.policytype.TPolicyTypeExample;

/**
 * @author  huangzl QQ: 272950754
 * @version 1.0
 * @since 1.0
 */


@Service("policyTypeService")
public class PolicyTypeServiceImpl implements IPolicyTypeService {

	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
    private TPolicyTypeMapper  policyTypeDao;
	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	@Override
	public TPolicyType getById(Long id){
	  return policyTypeDao.selectByPrimaryKey(id);
	}
	
	/**
	 *根据条件查询列表
	 */
	@Override
	public List<TPolicyType> selectPolicyType(TPolicyTypeExample example){
		return policyTypeDao.selectByExample(example);
	}
	
	
	
	/**
	 * 更新
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int updatePolicyTypeById(TPolicyType newTPolicyType){
		logger.debug("updatePolicyType(TPolicyType: "+newTPolicyType);
		return  policyTypeDao.updateByPrimaryKeySelective(newTPolicyType);		
	}
	
	/**
	 * 新增
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int addPolicyType(TPolicyType newTPolicyType){
		logger.debug("addPolicyType: "+newTPolicyType);
		return policyTypeDao.insertSelective(newTPolicyType);
	}
	
	/**
	 * 分页查询
	 * @param param
	 * @param page
	 * @return
	 */
	public PageDo<TPolicyType> getPolicyTypePage(Map<String, Object> param){
		logger.info("----getPolicyTypePage----"+param);
        PageDo page = (PageDo)param.get(Constants.MYBATIS_PAGE);
        if(page == null){
        	page = new PageDo<TPolicyType>();
        }
        List<TPolicyType> list =  policyTypeDao.selectList(param);
        page.setDatas(list);
        return page;
	}
	
	/**
	 * 删除
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int deleteById(Long id){
		logger.debug("deleteByIdPolicyType:"+id);
		return  policyTypeDao.deleteByPrimaryKey(id);		
	}

}
