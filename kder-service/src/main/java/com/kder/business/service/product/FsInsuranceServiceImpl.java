/*
 * Powered By  huangzl QQ: 272950754
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2018
 */

package com.kder.business.service.product;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kder.business.common.constant.Constants;
import com.kder.business.common.page.PageDo;
import com.kder.business.dao.product.TFsInsuranceMapper;
import com.kder.business.entity.product.TFsInsuranceExample;
import com.kder.business.entity.product.TFsInsuranceWithBLOBs;

/**
 * @author  huangzl QQ: 272950754
 * @version 1.0
 * @since 1.0
 */


@Service("productService")
public class FsInsuranceServiceImpl implements IFsInsuranceService {

	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
    private TFsInsuranceMapper  fsInsuranceDao;
	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	@Override
	public TFsInsuranceWithBLOBs getById(Long id){
	  return fsInsuranceDao.selectByPrimaryKey(id.intValue());
	}
	
	/**
	 *根据条件查询列表
	 */
	@Override
	public List<TFsInsuranceWithBLOBs> selectFsInsurance(TFsInsuranceExample example){
		return fsInsuranceDao.selectByExampleWithBLOBs(example);
	}
	
	
	
	/**
	 * 更新
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int updateFsInsuranceById(TFsInsuranceWithBLOBs newTFsInsuranceWithBLOBs){
		logger.debug("updateFsInsurance(TFsInsuranceWithBLOBs: "+newTFsInsuranceWithBLOBs);
		return  fsInsuranceDao.updateByPrimaryKeySelective(newTFsInsuranceWithBLOBs);		
	}
	
	/**
	 * 新增
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int addFsInsurance(TFsInsuranceWithBLOBs newTFsInsuranceWithBLOBs){
		logger.debug("addFsInsurance: "+newTFsInsuranceWithBLOBs);
		return fsInsuranceDao.insertSelective(newTFsInsuranceWithBLOBs);
	}
	
	/**
	 * 分页查询
	 * @param param
	 * @param page
	 * @return
	 */
	public PageDo<TFsInsuranceWithBLOBs> getFsInsurancePage(Map<String, Object> param, PageDo<TFsInsuranceWithBLOBs> page){
//		logger.info("----getFsInsurancePage----"+param);
//        param.put(Constants.MYBATIS_PAGE, page);
//        List<TFsInsuranceWithBLOBs> list =  fsInsuranceDao.queryListPage(param);
//        page.setModelList(list);
//        return page;
		return null;
	}
	
	/**
	 * 删除
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int deleteById(Long id){
		logger.debug("deleteByIdFsInsurance:"+id);
		return  fsInsuranceDao.deleteByPrimaryKey(id.intValue());		
	}

}
