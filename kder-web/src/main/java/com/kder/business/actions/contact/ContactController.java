package com.kder.business.actions.contact;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kder.business.actions.common.BaseController;


@RestController
@RequestMapping("/contact")
public class ContactController extends BaseController{ 
	

	
	
	/**
     * 填写保单页面
     * @param request
     * @param response
     * @return  
     */
    @RequestMapping(value = "/list", method ={ RequestMethod.GET, RequestMethod.POST })
    public  ModelAndView  list() {
         ModelAndView mav = new ModelAndView("center/centerContacts");
         return mav;
    }

    
    /**
     * 提交保单页面
     * @param request
     * @param response
     * @return  
     */
    @RequestMapping(value = "/addContact", method ={  RequestMethod.POST })
    public  ModelAndView  submitPolicy() {
    	 String productId = getString("productId");
         ModelAndView mav = new ModelAndView("center/centerAddContact");
         mav.addObject("productId", productId);
         return mav;
    }
    
    
    /**
     * 提交保单页面
     * @param request
     * @param response
     * @return  
     */
    @RequestMapping(value = "/saveContact", method ={  RequestMethod.POST })
    public  ModelAndView  saveContact() {
    	 String productId = getString("productId");
         ModelAndView mav = new ModelAndView("center/centerAddContact");
         mav.addObject("productId", productId);
         return mav;
    }


}
