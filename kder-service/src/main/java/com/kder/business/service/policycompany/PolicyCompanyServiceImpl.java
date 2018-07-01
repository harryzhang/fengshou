/*
 * Powered By  huangzl QQ: 272950754
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2018
 */

package com.kder.business.service.policycompany;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kder.business.common.constant.Constants;
import com.kder.business.common.page.PageDo;
import com.kder.business.dao.policycompany.PolicyCompanyMapper;
import com.kder.business.entity.policycompany.PolicyCompanyDo;
import com.kder.business.entity.policycompany.PolicyCompanyExample;

/**
 * @author  huangzl QQ: 272950754
 * @version 1.0
 * @since 1.0
 */


@Service("policyCompanyService")
public class PolicyCompanyServiceImpl implements IPolicyCompanyService {

	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
    private PolicyCompanyMapper  policyCompanyDao;
	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	@Override
	public PolicyCompanyDo getById(Long id){
	  return policyCompanyDao.selectByPrimaryKey(id);
	}
	
	/**
	 *根据条件查询列表
	 */
	@Override
	public List<PolicyCompanyDo> selectPolicyCompany(PolicyCompanyExample example){
		return policyCompanyDao.selectByExample(example);
	}
	
	
	/**
	 * 更新
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int updatePolicyCompanyById(PolicyCompanyDo newPolicyCompanyDo){
		logger.debug("updatePolicyCompany(PolicyCompanyDo: "+newPolicyCompanyDo);
		return policyCompanyDao.updateByPrimaryKeySelective(newPolicyCompanyDo);
	}
	
	/**
	 * 新增
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int addPolicyCompany(PolicyCompanyDo newPolicyCompanyDo){
		logger.debug("addPolicyCompany: "+newPolicyCompanyDo);
		return policyCompanyDao.insertSelective(newPolicyCompanyDo);
	}
	
	/**
	 * 删除
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int deleteById(Long id){
		logger.debug("deleteByIdPolicyCompany:"+id);
		return policyCompanyDao.deleteByPrimaryKey(id);
	}

	@Override
	public PageDo<PolicyCompanyDo> getPolicyCompanyPage(
			Map<String, Object> param, PageDo<PolicyCompanyDo> page) {
		logger.info("----getPolicyCompanyPage----"+param);
        param.put(Constants.MYBATIS_PAGE, page);
        List<PolicyCompanyDo> list =  policyCompanyDao.queryListPage(param);
        page.setDatas(list);
        return page;
	}

}
