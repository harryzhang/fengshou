/*
 * Powered By  huangzl QQ: 272950754
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2018
 */


package com.kder.business.action.policytype;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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
import com.kder.business.entity.policytype.TPolicyType;
import com.kder.business.service.policytype.IPolicyTypeService;



/**
 * @author  huangzl QQ: 272950754
 * @version 1.0
 * @since 1.0
 */

@Controller
@RequestMapping("/policytype")
public class PolicyTypeController extends BaseAction{
	
	@Resource
	private IPolicyTypeService policyTypeService;

	/**
     * 去列表页面
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model){
        return "policytype/listPolicyType";
    }
	
	@RequestMapping("/listPolicyType")
    public void listPolicyType(PageDo<TPolicyType> page,
    							  ModelMap model,
    							  HttpServletResponse response) {

        logger.info("----listPolicyType----");
        try{
            String companyName = getString("searchPolicyName");
            Map<String,Object> param = new HashMap<String,Object>();
            if(StringUtils.isNotBlank(companyName)){
                param.put("policyName",companyName);
                model.addAttribute("searchPolicyName",companyName);
            }
            String managerName = getString("searManagerName");
            if(StringUtils.isNotBlank(managerName)){
                param.put("managerName", managerName);
                model.addAttribute("searManagerName",managerName);
            }
            param.put("page", page);
            page = policyTypeService.getPolicyTypePage(param);
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
    @RequestMapping("/addPolicyType")
    public String addPolicyType(String id, ModelMap modelMap, HttpServletResponse response) {
        logger.info("----addPolicyType----");
        try{
            if(StringUtils.isNotBlank(id)){
                TPolicyType tPolicyType = policyTypeService.getById(Long.valueOf(id));
                if(null != tPolicyType){
                    modelMap.addAttribute("policytype", tPolicyType);
                }
            }
            return "policytype/addPolicyType";
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
    @RequestMapping("/savePolicyType")
    @ResponseBody
    public void savePolicyType(TPolicyType tPolicyType, 
    							  HttpServletRequest request, 
    							  HttpServletResponse response) {
        logger.info("----savePolicyType------");
        try{
            Long id = tPolicyType.getId();
            Long userId = new Long(this.getUserId());
            
            int i = 0;
            if (id != null && id.intValue()>0) {
            	tPolicyType.setUpdateuserid(userId);
            	tPolicyType.setUpdatetime(new Date());
                i = policyTypeService.updatePolicyTypeById(tPolicyType);
            } else {
            	tPolicyType.setCreateuserid(userId);
            	tPolicyType.setCreatetime(new Date());
            	
                i = policyTypeService.addPolicyType(tPolicyType);
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
        logger.info("----end savePolicyType--------");
    }
    
	
	
}

