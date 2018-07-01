package com.kder.business.action.report;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.kder.business.action.BaseAction;
import com.kder.business.common.exception.BusinessException;
import com.kder.business.common.page.PageDo;
import com.kder.business.service.report.IReportService;

@Controller
@RequestMapping("/report")
public class ReportController extends BaseAction {
	@Resource
	IReportService reportService;
	
	/**
     * 去列表页面
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model){
    	String reportType= this.getString("reportType");
    	
    	model.addAttribute("reportType", reportType);
        return "report/reportIndex";
    }
	
	/**
	 *  searchOrgName:
	 *	searchCompanyName:
	 *	searchProductName:
	 *	searchManagerName:
	 *	reportType:COMMISSION
	 *	searchStartTime:
	 *	searchEndTime:
	 *	groupByOrg:true
	 *	groupByProduct:false
	 *	groupByManager:false
	 *	groupByCompany:false
	 *	groupByTypeDate:m
     * 报表查询页面
     *
     * @return
     */
    @RequestMapping("/queryReport")
    public void queryReport(PageDo<Map<String,Object>> page,
    		                    ModelMap modelMap, 
    							HttpServletResponse response) {
        logger.info("----queryReport----");
        try{
        	String reportType = this.getString("reportType");
        	Map<String,Object> param = new HashMap<String,Object>();
        	param.put("reportType", reportType);

            String searchOrgName = getString("searchOrgName");
            if(StringUtils.isNotBlank(searchOrgName)){
                param.put("searchOrgName",searchOrgName);
            }
            String searchCompanyName = getString("searchCompanyName");
            if(StringUtils.isNotBlank(searchCompanyName)){
                param.put("searchCompanyName", searchCompanyName);
            }
            String searchProductName = getString("searchProductName");
            if(StringUtils.isNotBlank(searchProductName)){
                param.put("searchProductName", searchProductName);
            }
            String searchManagerName = getString("searchManagerName");
            if(StringUtils.isNotBlank(searchManagerName)){
                param.put("searchManagerName", searchManagerName);
            }
            String searchStartTime = getString("searchStartTime");
            if(StringUtils.isNotBlank(searchStartTime)){
                param.put("searchStartTime", searchStartTime);
            }
            String searchEndTime = getString("searchEndTime");
            if(StringUtils.isNotBlank(searchEndTime)){
                param.put("searchEndTime", searchEndTime);
            }
            
            String groupByOrg = getString("groupByOrg");
            if(StringUtils.isNotBlank(groupByOrg)){
                param.put("groupByOrg", groupByOrg);
            }
            
            String groupByProduct = getString("groupByProduct");
            if(StringUtils.isNotBlank(groupByProduct)){
                param.put("groupByProduct", groupByProduct);
            }
            String groupByManager = getString("groupByManager");
            if(StringUtils.isNotBlank(groupByManager)){
                param.put("groupByManager", groupByManager);
            }
            
            String groupByCompany = getString("groupByCompany");
            if(StringUtils.isNotBlank(groupByCompany)){
                param.put("groupByCompany", groupByCompany);
            }
            
            String groupByTypeDate = getString("groupByTypeDate");
            if(StringUtils.isNotBlank(groupByTypeDate)){
                param.put("groupByTypeDate", groupByTypeDate);
            }
            param.put("page", page);
            page = reportService.selectReport(param);
            outPrint(response, JSONObject.toJSON(page));
        }catch(Exception e){
            logger.error("页面异常",e);
            throw new BusinessException("系统繁忙，请稍后再试");
        }

    }
}
