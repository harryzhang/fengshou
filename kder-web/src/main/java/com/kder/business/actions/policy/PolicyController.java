package com.kder.business.actions.policy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kder.business.actions.common.BaseController;


@RestController
@RequestMapping("/policy")
public class PolicyController extends BaseController {
	
	
	/**
     * 填写保单页面
     * @param request
     * @param response
     * @return  
     */
    @RequestMapping(value = "/listPolicy", method ={ RequestMethod.GET, RequestMethod.POST })
    public  ModelAndView  listPolicy() {
    	 String productId = getString("productId");
         ModelAndView mav = new ModelAndView("center/centerOrder");
         mav.addObject("productId", productId);
         return mav;
    }
    
	
	/**
     * 填写保单页面
     * @param request
     * @param response
     * @return  
     */
    @RequestMapping(value = "/writePolicy", method ={ RequestMethod.GET, RequestMethod.POST })
    public  ModelAndView  writePolicy() {
    	 String productId = getString("productId");
         ModelAndView mav = new ModelAndView("policy/writePolicy");
         mav.addObject("productId", productId);
         return mav;
    }

    
    /**
     * 提交保单页面
     * @param request
     * @param response
     * @return  
     */
    @RequestMapping(value = "/submitPolicy", method ={  RequestMethod.POST })
    public  ModelAndView  submitPolicy() {
    	 String productId = getString("productId");
         ModelAndView mav = new ModelAndView("policy/confirmPolicy");
         mav.addObject("productId", productId);
         return mav;
    }
    
    
    /**
     * 提交保单页面
     * @param request
     * @param response
     * @return  
     */
    @RequestMapping(value = "/confirmPolicy", method ={  RequestMethod.POST })
    public  ModelAndView  confirmPolicy() {
    	 String productId = getString("productId");
         ModelAndView mav = new ModelAndView("policy/writePolicy");
         mav.addObject("productId", productId);
         return mav;
    }
}
