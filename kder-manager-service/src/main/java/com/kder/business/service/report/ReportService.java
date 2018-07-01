package com.kder.business.service.report;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.kder.business.common.constant.Constants;
import com.kder.business.common.page.PageDo;
import com.kder.business.common.util.StringUtil;
import com.kder.business.dao.report.IReportDao;



@Service("reportService")
public class ReportService implements IReportService {
	
	@Resource
	IReportDao reportDao;
	
	/**
	 * 按周
	 * DATE_FORMAT(create_time,'%Y%u') weeks
	 * 按月
	 * DATE_FORMAT(create_time,'%Y%m') months 
	 * 按天
	 * DATE_FORMAT(create_time,'%Y%m%d') days  
	 */
	/*
	 * sql的条件
	 * <if test="fieldsClause != null">
	 *		${fieldsClause}
 	 * </if>
     * <if test="groupByClause != null">
	 *	group by ${groupByClause}
     * </if>
     * <if test="orderByClause != null">
	 *	order by ${orderByClause}
     * </if>
	 * (non-Javadoc)
	 * @see com.kder.business.service.report.IReportService#selectReport(java.util.Map)
	 */
	@Override
	public PageDo<Map<String, Object>> selectReport(Map<String, Object> param) {
		PageDo<Map<String, Object>> page = (PageDo) param.get(Constants.MYBATIS_PAGE);
		
		String groupByClause  = createGroupByClause(param);
		String orderByClause  = createOrderByClause(param);
		String fieldsClause  = createFieldsClause(param);
		if(groupByClause != null){
			param.put("groupByClause", groupByClause);
		}
		if(orderByClause != null){
			param.put("orderByClause", orderByClause);
		}
		if(fieldsClause != null){
			param.put("fieldsClause", fieldsClause);
		}
		
		String chooseType = (String)param.get("reportType");
		if("ORDER".equalsIgnoreCase(chooseType)){
			List<Map<String, Object>> datas = reportDao.selectOrderReport(param);
			page.setDatas(datas);
		}
		if("COMMISSION".equalsIgnoreCase(chooseType)){
			List<Map<String, Object>> datas = reportDao.selectCommissionReport(param);
			page.setDatas(datas);
		}
		if("PEOPLE".equalsIgnoreCase(chooseType)){
			List<Map<String, Object>> datas = reportDao.selectPeopleReport(param);
			page.setDatas(datas);
		}
		return page;
	}

	private String createFieldsClause(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	private String createOrderByClause(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	private String createGroupByClause(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return null;
	}
 
}
