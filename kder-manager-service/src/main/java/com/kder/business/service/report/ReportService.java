package com.kder.business.service.report;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kder.business.common.constant.Constants;
import com.kder.business.common.page.PageDo;
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
		if(groupByClause != null && !"".equals(groupByClause)){
			param.put("groupByClause", groupByClause);
		}
		if(orderByClause != null && !"".equals(orderByClause)){
			param.put("orderByClause", orderByClause);
		}
		if(fieldsClause == null || "".equals(fieldsClause)){
			return page;
		}
		param.put("fieldsClause", fieldsClause);
		
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

	/**
	 * SELECT org_company,policy_company,product_name,sales_man ,SUM(IFNULL(order_amt,0))
	 * FROM ct_order
		GROUP BY org_company,policy_company,product_name,sales_man	 
		ORDER BY  org_company,policy_company,product_name,sales_man 
	 * @param param
	 * @return
	 */
	private String createFieldsClause(Map<String, Object> param) {
		String reportType = (String)param.get("reportType");
		String groupByOrg = (String)param.get("groupByOrg");
		String groupByProduct = (String)param.get("groupByProduct");
		String groupByManager = (String)param.get("groupByManager");
		String groupByCompany = (String)param.get("groupByCompany");
		String groupByTypeDate = (String)param.get("groupByTypeDate");
		StringBuffer sb = new StringBuffer();
		if("ORDER".equals(reportType)){
			if("true".equals(groupByOrg)){
				sb.append("org_company").append(",");
			}
			if("true".equals(groupByProduct)){
				sb.append("product_name").append(",");
			}
			if("true".equals(groupByCompany)){
				sb.append("policy_company").append(",");
			}
			if("true".equals(groupByManager)){
				sb.append("sales_man").append(",");
			}
			if("m".equals(groupByTypeDate)){
				sb.append("DATE_FORMAT(create_time,'%Y%m') group_time").append(",");
			}else if("d".equals(groupByTypeDate)){
				sb.append("DATE_FORMAT(create_time,'%Y%m%d') group_time").append(",");
			}else if("w".equals(groupByTypeDate)){
				sb.append("DATE_FORMAT(create_time,'%Y%u') group_time").append(",");
			}
		}else if("COMMISSION".equals(reportType)){
			if("true".equals(groupByOrg)){
				sb.append("a.org_company").append(",");
			}
			if("true".equals(groupByProduct)){
				sb.append("a.product_name").append(",");
			}
			if("true".equals(groupByCompany)){
				sb.append("a.policy_company").append(",");
			}
			if("true".equals(groupByManager)){
				sb.append("a.sales_man").append(",");
			}
			if("m".equals(groupByTypeDate)){
				sb.append("DATE_FORMAT(b.create_time,'%Y%m') group_time").append(",");
			}else if("d".equals(groupByTypeDate)){
				sb.append("DATE_FORMAT(b.create_time,'%Y%m%d') group_time").append(",");
			}else if("w".equals(groupByTypeDate)){
				sb.append("DATE_FORMAT(b.create_time,'%Y%u') group_time").append(",");
			}
		}
		if(sb.length()>0){
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	 
	private String createOrderByClause(Map<String, Object> param) {
		return null;
	}

	private String createGroupByClause(Map<String, Object> param) {
		String reportType = (String)param.get("reportType");
		String groupByOrg = (String)param.get("groupByOrg");
		String groupByProduct = (String)param.get("groupByProduct");
		String groupByManager = (String)param.get("groupByManager");
		String groupByCompany = (String)param.get("groupByCompany");
		String groupByTypeDate = (String)param.get("groupByTypeDate");
		StringBuffer sb = new StringBuffer();
		if("ORDER".equals(reportType)){
			if("true".equals(groupByOrg)){
				sb.append("org_company").append(",");
			}
			if("true".equals(groupByProduct)){
				sb.append("product_name").append(",");
			}
			if("true".equals(groupByCompany)){
				sb.append("policy_company").append(",");
			}
			if("true".equals(groupByManager)){
				sb.append("sales_man").append(",");
			}
			if("m".equals(groupByTypeDate)){
				sb.append("DATE_FORMAT(create_time,'%Y%m') ").append(",");
			}else if("d".equals(groupByTypeDate)){
				sb.append("DATE_FORMAT(create_time,'%Y%m%d') ").append(",");
			}else if("w".equals(groupByTypeDate)){
				sb.append("DATE_FORMAT(create_time,'%Y%u') ").append(",");
			}
		}else if("COMMISSION".equals(reportType)){
			if("true".equals(groupByOrg)){
				sb.append("a.org_company").append(",");
			}
			if("true".equals(groupByProduct)){
				sb.append("a.product_name").append(",");
			}
			if("true".equals(groupByCompany)){
				sb.append("a.policy_company").append(",");
			}
			if("true".equals(groupByManager)){
				sb.append("a.sales_man").append(",");
			}
			if("m".equals(groupByTypeDate)){
				sb.append("DATE_FORMAT(b.create_time,'%Y%m') ").append(",");
			}else if("d".equals(groupByTypeDate)){
				sb.append("DATE_FORMAT(b.create_time,'%Y%m%d') ").append(",");
			}else if("w".equals(groupByTypeDate)){
				sb.append("DATE_FORMAT(b.create_time,'%Y%u') ").append(",");
			}
		}
		if(sb.length()>0){
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
 
}
