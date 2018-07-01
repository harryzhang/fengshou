package com.kder.business.action.report;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.kder.business.action.BaseAction;
import com.kder.business.common.exception.BusinessException;
import com.kder.business.common.page.PageDo;
import com.kder.business.service.report.IReportService;
import com.sun.xml.internal.ws.util.StringUtils;

@Controller
@RequestMapping("/report")
public class ReportAction extends BaseAction{
	
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

            String searchName = getString("searchName");
            if(StringUtils.isNotBlank(searchName)){
                param.put("searchName",searchName);
                modelMap.addAttribute("searchName",searchName);
            }
            String searchCode = getString("searchCode");
            if(StringUtils.isNotBlank(searchCode)){
                param.put("searchCode", searchCode);
                modelMap.addAttribute("searchCode",searchCode);
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
