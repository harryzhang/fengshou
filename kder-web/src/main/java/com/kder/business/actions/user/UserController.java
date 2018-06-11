package com.kder.business.actions.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.kder.business.actions.common.BaseController;
import com.kder.business.common.result.Result;
import com.kder.business.common.util.DataEncrypt;
import com.kder.business.common.util.MD5Encrypt;
import com.kder.business.entity.user.People;
import com.kder.business.entity.user.PeopleExample;
import com.kder.business.service.dict.IDictService;
import com.kder.business.service.sms.ISmsService;
import com.kder.business.service.user.IUserService;
import com.kder.web.contants.WebContants;
import com.kder.web.util.TokenUtil;

/** 
 * 账户处理器，注册、登录等
 * @author parudy
 * @date 2018年3月24日 
 * @version v1.0
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    private final static Logger logger = Logger.getLogger(UserController.class);

    @Resource
    private IUserService userService;
  
    @Resource
    private ISmsService smsService;

    /** 
     * 用户注册前端参数：                   phone: '',
     *                     code: '',
     *                     indentify: '',
     *                     psw: '',
     *                     confirmPsw: ''
     * @param userDo
     * @param bindingResult
     * @return  
     */
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public Result<?> reg() {
    	
        logger.info("用户注册");

        String phone = getString("phone");
        String code = getString("code");
        String indentify = getString("indentify");
        String psw = getString("psw");
        String confirmPsw = getString("confirmPsw");
        String validPage = getString("page");
        
        Assert.hasText(phone, "手机号不能为空");
        Assert.hasText(psw,"密码不能为空");
        
        Assert.isTrue(smsService.checkSms(phone, validPage, indentify),"手机验证码不正确");
        Result ret = this.checkValidateCode();
        Assert.isTrue(ret.isSuccess(),"图形验证码不正确");
        Assert.isTrue(StringUtils.equals(psw, confirmPsw),"两次密码不一致");
        
        
        People userDo = new People();
        userDo.setPeoplePhone(phone);
        userDo.setPeoplePassword(MD5Encrypt.getMessageDigest(psw));
        
        Result<?> result = userService.reg(userDo);

        logger.info("用户注册结果:" + JSON.toJSONString(result));
        return result;
    }
    
    
    /** 
     * 检查用户是否登录
     * @param userDo
     * @param bindingResult
     * @return  
     */
    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    public Result<?> checkLogin() {

        People userDo = (People) this.getRequest().getSession().getAttribute(WebContants.session_user);
        if(userDo == null){
        	return Result.failureResult("未登录");
        }
        String token = TokenUtil.createToken(userDo.getPeopleId());
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("loginUser", userDo);
        return Result.successResult("登录成功", map);
    
    }
    

    /**
     * 登录 
     * @param request
     * @param response
     * @return  
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<?> login() {
    	
    	String userName = getString("userName");
    	String password = getString("password");
        //String mobile = getString("mobile");
        Assert.hasText(userName, "请输入用户名");
        Assert.hasText(password, "请输入密码");
        //password = DataEncrypt.encrypt(password);
        
        Result ret = this.checkValidateCode();
        Assert.isTrue(ret.isSuccess(),"图形验证码不正确");
        
        logger.info("用户登录, userName:" + userName + "; password:" + password);
        
        PeopleExample example = new PeopleExample();
        example.createCriteria().andPeoplePhoneEqualTo(userName);
		List<People> userLst = userService.selectByExample(example);
        Assert.notEmpty(userLst, "用户不存在");


        People userDo = userLst.get(0);
        
        password = MD5Encrypt.getMessageDigest(password);
        if (!userName.equals(userDo.getPeoplePhone()) || !password.equals(userDo.getPeoplePassword())) {
            return Result.failureResult("用户名或者密码不正确");
        }

        if (userDo.getPeopleState().intValue() != 0) {
            return Result.failureResult("当前用户已被锁定,不允许登录!");
        }
        
        maintainSession(userDo);
        String token = TokenUtil.createToken(userDo.getPeopleId());
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("userId", userDo.getPeopleId());
        return Result.successResult("登录成功", map);
    }

    /**
     * 维护session
     * @param userDo
     */
    private void maintainSession(People userDo) {
		this.getRequest().getSession().setAttribute(WebContants.session_user, userDo);
	}

	/**
     * 注销
     * @param request
     * @param response
     * @return  
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result<?> logout() {
        Integer userId = getUserId();

        logger.info("用户注销, userId:" + userId);

        TokenUtil.deleteToken(userId);
        this.getRequest().getSession().removeAttribute(WebContants.session_user);
        this.getRequest().getSession().invalidate();
        return Result.successResult("注销成功");
    }

  
}
