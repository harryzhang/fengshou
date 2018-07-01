/*
 * Powered By  huangzl QQ: 272950754
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2018
 */


package com.kder.business.action.privatecust;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.kder.business.action.BaseAction;
import com.kder.business.common.exception.BusinessException;
import com.kder.business.common.page.PageDo;
import com.kder.business.common.result.Result;
import com.kder.business.common.util.ExeclTools;
import com.kder.business.entity.privatecust.CtPrivateCust;
import com.kder.business.entity.privatecust.CtPrivateCustExample;
import com.kder.business.service.privatecust.IPrivateCustService;



/**
 * @author  huangzl QQ: 272950754
 * @version 1.0
 * @since 1.0
 */

@Controller
@RequestMapping("/ctprivatecust")
public class PrivateCustController extends BaseAction{
	@Resource
	private IPrivateCustService ctPrivateCustService;

	/**
     * 去列表页面
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model){
        return "ctprivatecust/listCtPrivateCust";
    }
	
	@RequestMapping("/listCtPrivateCust")
    public void listCtPrivateCust(PageDo<CtPrivateCust> page,
    							  ModelMap model,
    							  HttpServletResponse response) {

        logger.info("----listCtPrivateCust----");
        try{
            String searchUserName = getString("searchUserName");
            Map<String,Object> param = new HashMap<String,Object>();
            if(StringUtils.isNotBlank(searchUserName)){
                param.put("userName",searchUserName);
                model.addAttribute("searchUserName",searchUserName);
            }
            String searchPhone = getString("searchPhone");
            if(StringUtils.isNotBlank(searchPhone)){
                param.put("phone", searchPhone);
                model.addAttribute("searchPhone",searchPhone);
            }
            page = ctPrivateCustService.getPrivateCustPage(param, page);
            outPrint(response, JSONObject.toJSON(page));
        }catch(Exception e){
            logger.error("查询清单异常",e);
            throw new BusinessException("系统繁忙，请稍后再试");
        }
    }
	
	
	  
    /**
     * 编辑页面
     *
     * @return
     */
    @RequestMapping("/addCtPrivateCust")
    public String addCtPrivateCust(String id, ModelMap modelMap, HttpServletResponse response) {
        logger.info("----addCtPrivateCust----");
        try{
            if(StringUtils.isNotBlank(id)){
                CtPrivateCust ctprivatecustDo = ctPrivateCustService.getById(Long.valueOf(id));
                if(null != ctprivatecustDo){
                    modelMap.addAttribute("ctprivatecust", ctprivatecustDo);
                }
            }
            return "ctprivatecust/addCtPrivateCust";
        }catch(Exception e){
            logger.error("跳转到数据字典编辑页面异常",e);
            throw new BusinessException("系统繁忙，请稍后再试");
        }

    }

    /**
     * 保存更新
     *
     * @return
     * @author: huangzlmf
     * @date: 2015年4月21日 12:49:05
     */
    @RequestMapping("/saveCtPrivateCust")
    @ResponseBody
    public void saveCtPrivateCust(CtPrivateCust ctprivatecustDo, 
    							  HttpServletRequest request, 
    							  HttpServletResponse response) {
        logger.info("----saveCtPrivateCust------");
        try{
            Long id = ctprivatecustDo.getId();
            Long userId = new Long(this.getUserId());
            
            int i = 0;
            if (id != null && id.intValue()>0) {
            	//ctprivatecustDo.setUpdateBy(userId);
            	//ctprivatecustDo.setUpdateTime(new Date());
                i = ctPrivateCustService.updateCtPrivateCustById(ctprivatecustDo);
            } else {
				//ctprivatecustDo.setCreateBy(userId);
            	//ctprivatecustDo.setCreateTime(new Date());
            	
                i = ctPrivateCustService.addCtPrivateCust(ctprivatecustDo);
            }

            if (i <= 0) {
                outPrint(response,this.toJSONString(Result.failureResult("操作失败")));
                return;
            }
            outPrint(response, this.toJSONString(Result.successResult("操作成功")));
        }catch(Exception e){
            logger.error("保存更新失败",e);
            outPrint(response, this.toJSONString(Result.failureResult("操作失败")));
        }
        logger.info("----end savePolicycompany--------");
    }
    
	/**
     * 导出数据
     */
    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        try {
            Long time = System.currentTimeMillis();
            CtPrivateCustExample example  = new CtPrivateCustExample();
            String searchPhone = getString("searchPhone");
            if(StringUtils.isNotBlank(searchPhone)){
                example.createCriteria().andPhoneEqualTo(searchPhone);
            }
            
            String searchUserName = getString("searchUserName");
            if(StringUtils.isNotBlank(searchUserName)){
                example.createCriteria().andUserNameEqualTo(searchUserName);
            }
            
            List<CtPrivateCust> ctprivatecustLst = ctPrivateCustService.selectCtPrivateCust(example);
            
            String excelHead = "数据导出";
            String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String fileName = URLEncoder.encode(excelHead + date + ".xls", "utf-8");
            List<String[]> excelheaderList = new ArrayList<String[]>();
            String[] excelheader = { "保险公司名称", "保险公司简称", "联系人姓名", "联系人手机号码", "跟进单员", "合作状态", "记录状态" };
            excelheaderList.add(0, excelheader);
            String[] excelData = { "policyName", "shortName", "contactName", "contactPhone", "managerName", "partnerStatus", "status" };
            HSSFWorkbook wb = ExeclTools.execlExport(excelheaderList, excelData, excelHead, ctprivatecustLst);
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            wb.write(response.getOutputStream());
            time = System.currentTimeMillis() - time;
            logger.info("导出数据，导出耗时(ms)：" + time);
        } catch (Exception e) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("下载失败");
            logger.error("导出数据，Excel下载失败", e);
            logger.error("导出数据异常", e);
            throw new BusinessException("系统繁忙，请稍后再试");
        } finally {
            response.flushBuffer();
        }

    }
	
}

