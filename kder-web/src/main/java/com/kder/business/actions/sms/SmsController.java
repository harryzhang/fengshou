package com.kder.business.actions.sms;


import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kder.business.actions.common.BaseController;
import com.kder.business.common.exception.BusinessException;
import com.kder.business.common.result.Result;
import com.kder.business.service.sms.ISmsService;

@RestController
@RequestMapping("/sms")
public class SmsController extends BaseController {
	
    private final static Logger logger = Logger.getLogger(SmsController.class);

    @Resource
    private ISmsService smsService;

    /** 
     * 发送短信 
     * @param page：  页面
     * @return  
     */
    @RequestMapping(value = "send", method = RequestMethod.POST)
    public Result<?> sendSms() {
        Integer userId = getUserId();
        String phone =getString("phone");
        String page = getString("page");
        
        Result ret = this.checkValidateCode();
        Assert.isTrue(ret.isSuccess(),"图形验证码不正确");
        
        Result result = Result.successResult("发送成功");
        try{
        	if(StringUtils.isNotBlank(phone)){
        		smsService.send(phone,page);
        	}else if(userId != null ){
        		smsService.send(userId,page);
        	}else{
        		result = Result.failureResult("缺少参数");
        	}
        }catch(BusinessException be){
        	result = Result.failureResult(be.getMessage());
	    }catch(Exception e){
	    	result = Result.failureResult("请重试");
	    }
        return result;
    }
    
    /** 
     * 发送短信
     * @return  
     */
    @RequestMapping(value = "checkSms", method = RequestMethod.POST)
    public Result<?> checkSms() {
    	Integer userId = getUserId();
    	String page = getString("page");
    	String smsCode = getString("smsCode");
    	String phone =getString("phone");
    	
    	Result result = Result.successResult("验证通过");
    	try{
    		boolean ret = false;
    		if(StringUtils.isNotBlank(phone)){
    			ret = smsService.checkSms(phone,page,smsCode);
        	}else if(userId != null ){
        		ret = smsService.checkSms(userId,page,smsCode);
        	}else{
        		result = Result.failureResult("缺少参数");
        	}
    		
    		if(ret == false){
    			result =  Result.failureResult("验证码错误");
    		}
    	}catch(Exception e){
    		result = Result.failureResult("验证码错误");
    	}
    	return result;
    }

}
