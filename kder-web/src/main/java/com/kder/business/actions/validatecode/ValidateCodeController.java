package com.kder.business.actions.validatecode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kder.business.actions.common.BaseController;
import com.kder.business.common.result.Result;
import com.kder.business.common.util.ValidateCodeGenetor;
import com.kder.web.contants.WebContants;


/** 
 * 账户处理器，注册、登录等
 * @author parudy
 * @date 2018年3月24日 
 * @version v1.0
 */
@RestController
@RequestMapping("/validatecode")
public class ValidateCodeController  extends BaseController {

	
	/**
	 * 响应验证码页面
	 * @return
	 */
	@RequestMapping(value="/getValidateCode")
	public void getValidateCode(HttpServletRequest request,
			                 	HttpServletResponse response) throws Exception{
		
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		//禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		
		String page = getString("page");
		Assert.hasText(page, "缺少page参数");
		
		HttpSession session = request.getSession();

		ValidateCodeGenetor vCode = new ValidateCodeGenetor(120,40,5,100);
		session.setAttribute(WebContants.validateCode, WebContants.validateCode+page+vCode.getCode());
		vCode.write(response.getOutputStream());
	}
	
	/**
	 * 响应验证码页面
	 * @return
	 */
	@RequestMapping(value="/checkValidateCode")
	public Result<?> checkValidateCode(HttpServletRequest request,
			                 		   HttpServletResponse response){
		return super.checkValidateCode();
	}
}
