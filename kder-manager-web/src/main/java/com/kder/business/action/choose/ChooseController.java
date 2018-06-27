package com.kder.business.action.choose;

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
import com.kder.business.common.page.NewPagination;
import com.kder.business.common.page.PageDo;
import com.kder.business.common.page.PageDoUtil;
import com.kder.business.service.choose.ICommonChooseService;


/**
 * @author  huangzl QQ: 272950754
 * @version 1.0
 * @since 1.0
 */

@Controller
@RequestMapping("/choose")
public class ChooseController extends BaseAction{
	
	@Resource
	private ICommonChooseService chooseService;
	
	
	/**
     * 去列表页面
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model){
    	String chooseType= this.getString("chooseType");
    	String retId = this.getString("retId");
    	String retText = this.getString("retText");
    	String dialogDivId = this.getString("dialogDivId");
    	
    	model.addAttribute("chooseType", chooseType);
    	model.addAttribute("retId", retId);
    	model.addAttribute("retText", retText);
    	model.addAttribute("dialogDivId", dialogDivId);
        return "choose/listChoose";
    }
	
	/**
     * 公共产品选择页面
     *
     * @return
     */
    @RequestMapping("/doChoose")
    public void doChoose(NewPagination<Map<String,Object>> pagination,
    		                    ModelMap modelMap, 
    							HttpServletResponse response) {
        logger.info("----dochoose----");
        try{
        	String chooseType = this.getString("chooseType");
        	Map<String,Object> param = new HashMap<String,Object>();
        	param.put("chooseType", chooseType);

            PageDo<Map<String,Object>> page = PageDoUtil.getPage(pagination);
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
            page = chooseService.getChoosePage(param, page);
            pagination = PageDoUtil.getPageValue(pagination, page);
            outPrint(response, JSONObject.toJSON(pagination));
        }catch(Exception e){
            logger.error("页面异常",e);
            throw new BusinessException("系统繁忙，请稍后再试");
        }

    }
    

}
