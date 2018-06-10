package com.kder.business.actions.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.kder.business.common.result.Result;
import com.kder.business.common.util.StringUtil;
import com.kder.business.entity.user.People;
import com.kder.web.contants.WebContants;
import com.kder.web.util.TokenUtil;

public class BaseController {

    protected String getString(String name) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String paraVal = request.getParameter(name);
        if (StringUtils.isNotBlank(paraVal)) {
            paraVal = StringUtil.scriptingFilter(StringUtil.FilteSqlInAndScript(paraVal));
            if ("null".equalsIgnoreCase(paraVal) || "undefined".equalsIgnoreCase(paraVal)) {
                return "";
            }
        }
        return paraVal;
    }

    protected Integer getUserId() {
        People userDo = getUser();
        if(null != userDo){
        	return userDo.getPeopleId();
        }else{
        	return null;
        }
    }
    
    protected People getUser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return (People)request.getSession().getAttribute(WebContants.session_user);
    }
    
    
    protected HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
    
    
    protected Result<?> checkValidateCode(){

		String code = getString("code");
		Assert.hasText(code,"验证码不能为空");
		String page = getString("page");
		Assert.hasText(code,"缺少page参数");
		
		HttpSession session = this.getRequest().getSession();
		String sessionCode = (String) session.getAttribute(WebContants.validateCode);
		Assert.isTrue(StringUtils.equalsIgnoreCase(WebContants.validateCode+page+code, sessionCode), "错误的验证码");
		return Result.successResult("验证通过");
	}
}
