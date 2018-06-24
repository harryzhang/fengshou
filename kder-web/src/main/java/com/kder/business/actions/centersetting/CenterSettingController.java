package com.kder.business.actions.centersetting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kder.business.actions.common.BaseController;


@RestController
@RequestMapping("/setting")
public class CenterSettingController extends BaseController{

	
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
    
}
