package com.kder.business.actions.centersetting;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kder.business.actions.common.BaseController;
import com.kder.business.common.page.PageDo;
import com.kder.business.common.util.StringUtil;
import com.kder.business.entity.order.CtOrder;
import com.kder.business.service.order.IOrderService;


@RestController
@RequestMapping("/setting")
public class CenterSettingController extends BaseController{
	
	@Resource
	private IOrderService orderService;

	
	/**
     * 填写保单页面
     * @param request
     * @param response
     * @return  
     */
    @RequestMapping(value = "/toSetting", method ={ RequestMethod.GET, RequestMethod.POST })
    public  ModelAndView  toSetting() {
         ModelAndView mav = new ModelAndView("center/centerSettings");
         return mav;
    }
    
    
	/**
     * 我的保单页面
     * @param request
     * @param response
     * @return  
     */
    @RequestMapping(value = "/mypolicy", method ={ RequestMethod.GET, RequestMethod.POST })
    public  ModelAndView  mypolicy() {
    	
    	ModelAndView mav = new ModelAndView("center/centerOrder");
    	Integer userId = this.getUserId();
//    	if(userId == null){
//    		 return mav;
//    	}
    	
    	Map<String, Object> param = new HashMap<String,Object>();
    	String orderStatus = this.getString("orderStatus");
    	if(StringUtils.isNotBlank(orderStatus)){
    		param.put("orderStatus", orderStatus);
    	}
    	param.put("userId", userId);
    	
    	String currentPage = this.getString("currentPage");
    	if(StringUtils.isBlank(currentPage)){
    		currentPage ="1";
    	}
    	
		PageDo<CtOrder> page = new PageDo();
		page.setCurrentPage(Long.valueOf(currentPage));
		page.setPageSize(5L);
		PageDo<CtOrder> ordPage = 	orderService.getOrderPage(param, page );
		mav.addObject("ordPage", ordPage);
        mav.addObject("orderStatus", orderStatus);
        return mav;
    }
    
}
