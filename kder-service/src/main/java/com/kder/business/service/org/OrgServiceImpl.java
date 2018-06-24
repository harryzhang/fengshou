/*
 * Powered By  huangzl QQ: 272950754
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2018
 */

package com.kder.business.service.org;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kder.business.common.constant.Constants;
import com.kder.business.common.page.PageDo;
import com.kder.business.dao.org.IOrgMapper;
import com.kder.business.entity.org.OrgDo;
import com.kder.business.entity.org.OrgExample;

/**
 * @author  huangzl QQ: 272950754
 * @version 1.0
 * @since 1.0
 */


@Service("orgService")
public class OrgServiceImpl implements IOrgService {

	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
    private IOrgMapper  orgDao;
	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	@Override
	public OrgDo getById(Long id){
	  return orgDao.selectByPrimaryKey(id);
	}
	
	/**
	 *根据条件查询列表
	 */
	@Override
	public List<OrgDo> selectOrg(OrgExample example){
		return orgDao.selectByExample(example);
	}
	
	
	
	/**
	 * 更新
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int updateOrgById(OrgDo newOrgDo){
		logger.debug("updateOrg(OrgDo: "+newOrgDo);
		return  orgDao.updateByPrimaryKeySelective(newOrgDo);		
	}
	
	/**
	 * 新增
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int addOrg(OrgDo newOrgDo){
		logger.debug("addOrg: "+newOrgDo);
		return orgDao.insertSelective(newOrgDo);
	}
	
	/**
	 * 分页查询
	 * @param param
	 * @param page
	 * @return
	 */
	public PageDo<OrgDo> getOrgPage(Map<String, Object> param, PageDo<OrgDo> page){
		logger.info("----getOrgPage----"+param);
        param.put(Constants.MYBATIS_PAGE, page);
        List<OrgDo> list =  orgDao.queryListPage(param);
        page.setModelList(list);
        return page;
	}
	
	/**
	 * 删除
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int deleteById(Long id){
		logger.debug("deleteByIdOrg:"+id);
		return  orgDao.deleteByPrimaryKey(id);		
	}

}
