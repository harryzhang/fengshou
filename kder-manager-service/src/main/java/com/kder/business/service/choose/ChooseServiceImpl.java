package com.kder.business.service.choose;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kder.business.common.constant.Constants;
import com.kder.business.common.page.PageDo;
import com.kder.business.dao.choose.ICommonChooseDao;

@Service("commonChooseService")
public class ChooseServiceImpl implements ICommonChooseService {
	
	@Resource
	private ICommonChooseDao commonChooseDao;

	@Override
	public PageDo<Map<String, Object>> getChoosePage(Map<String, Object> param,
			PageDo<Map<String, Object>> page) {
		
		param.put(Constants.MYBATIS_PAGE, page);
		
		String chooseType = (String)param.get("chooseType");
		if("PROD".equalsIgnoreCase(chooseType)){
			List<Map<String, Object>> datas = commonChooseDao.getChooseProductPage(param);
			page.setDatas(datas);
		}
		if("MANAGER_PEOPLE".equalsIgnoreCase(chooseType)){
			List<Map<String, Object>> datas = commonChooseDao.getChooseManagerPeoplePage(param);
			page.setDatas(datas);
		}
		if("PEOPLE".equalsIgnoreCase(chooseType)){
			List<Map<String, Object>> datas = commonChooseDao.getChoosePeoplePage(param);
			page.setDatas(datas);
		}
		if("ORDER".equalsIgnoreCase(chooseType)){
			List<Map<String, Object>> datas = commonChooseDao.getChooseOrderPage(param);
			page.setDatas(datas);
		}
		if("ORG".equalsIgnoreCase(chooseType)){
			List<Map<String, Object>> datas = commonChooseDao.getChooseOrgPage(param);
			page.setDatas(datas);
		}
		if("POLICY_COMPANY".equalsIgnoreCase(chooseType)){
			List<Map<String, Object>> datas = commonChooseDao.getChoosePolicyCompanyPage(param);
			page.setDatas(datas);
		}
		return page;
	}

	
	
}
