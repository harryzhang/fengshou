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
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.kder.business.actions.common.BaseController;
import com.kder.business.common.exception.BusinessException;
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
        
        String clientType = getString("clientType");
        if(!"mobile".equalsIgnoreCase(clientType)){
	        Result ret = this.checkValidateCode();
	        Assert.isTrue(ret.isSuccess(),"图形验证码不正确");
	        Assert.isTrue(StringUtils.equals(psw, confirmPsw),"两次密码不一致");
        }
        
        
        People userDo = new People();
        userDo.setPeoplePhone(phone);
        userDo.setPeoplePassword(MD5Encrypt.getMessageDigest(psw));
        try{
        	Result<?> result = userService.reg(userDo);
        	logger.info("用户注册结果:" + JSON.toJSONString(result));
            return result;
        }catch(BusinessException e){
        	Result<?> result = Result.failureResult(e.getMessage());
        	 return result;
        }

        
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
        
        String clientType = getString("clientType");
        if(!"mobile".equalsIgnoreCase(clientType)){
	        Result ret = this.checkValidateCode();
	        Assert.isTrue(ret.isSuccess(),"图形验证码不正确");
        }
        
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

    
    
    
    @RequestMapping(value = "/toChangePwd", method ={  RequestMethod.GET,RequestMethod.POST })
    public  ModelAndView  toChangePwd() {
         ModelAndView mav = new ModelAndView("center/centerModifyPassword");
         return mav;
    }
    @RequestMapping(value = "/toChangeMail", method ={  RequestMethod.GET,RequestMethod.POST })
    public  ModelAndView  toChangeMail() {
    	ModelAndView mav = new ModelAndView("center/centerEmail");
    	return mav;
    }
    
    /**
     * 邮箱认证
     * @param request
     * @param response
     * @return  
     */
    @RequestMapping(value = "/changeMail", method = RequestMethod.POST)
    public Result<?> changeMail() {
    	
    	String email = getString("email");
    	String identity = getString("identity");
    	String stepIndex = getString("stepIndex");
        Assert.hasText(email, "请输入邮箱地址");
        Assert.hasText(stepIndex, "当前步骤获取异常");
        
        logger.info("changeMail , email:" + email + "; identity:" + identity);
        
        Integer userId = this.getUserId();
        Assert.notNull(userId, "未登录");
        
        People userDo = userService.selectByPrimaryKey(userId);
        Assert.notNull(userDo, "用户不存在");
        
        userDo.setPeopleMail(email);
        userService.updateByPrimaryKey(userDo);
        
        String token = TokenUtil.createToken(userDo.getPeopleId());
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        return Result.successResult("邮箱修改成功", map);
    }
    
    
    /**
     * 根据原密码修改密码 
     * @param request
     * @param response
     * @return  
     */
    @RequestMapping(value = "/changePwd", method = RequestMethod.POST)
    public Result<?> changePwd() {
    	
    	String oldPwd = getString("oldPwd");
    	String newPwd = getString("newPwd");
    	String confirmNewPwd = getString("confirmNewPwd");
        Assert.hasText(newPwd, "请输入新密码");
        Assert.hasText(oldPwd, "请输入原密码");
        //Result ret = this.checkValidateCode();
        //Assert.isTrue(ret.isSuccess(),"图形验证码不正确");
        
        Assert.isTrue(newPwd.equals(confirmNewPwd),"两次输入的密码不一致");
        
        logger.info("根据原密码修改密码 , newPwd:" + newPwd + "; oldPwd:" + oldPwd);
        
        Integer userId = this.getUserId();
        Assert.notNull(userId, "未登录");
        
        People userDo = userService.selectByPrimaryKey(userId);
        Assert.notNull(userDo, "用户不存在");
        
        oldPwd = MD5Encrypt.getMessageDigest(oldPwd);
        if (!oldPwd.equals(userDo.getPeoplePassword())) {
            return Result.failureResult("原密码不正确");
        }

        newPwd = MD5Encrypt.getMessageDigest(newPwd);
        userDo.setPeoplePassword(newPwd);
        userService.updateByPrimaryKey(userDo);
        
        String token = TokenUtil.createToken(userDo.getPeopleId());
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        return Result.successResult("密码修改成功", map);
    }
    
    
    @RequestMapping(value = "/toForgetPwd", method ={  RequestMethod.GET,RequestMethod.POST })
    public  ModelAndView  toForgetPwd() {
         ModelAndView mav = new ModelAndView("login/forgetPassword");
         return mav;
    }
    
    /**
     * 忘记密码 
     * @param request
     * @param response
     * @return  
     */
    @RequestMapping(value = "/forgetPwd", method = RequestMethod.POST)
    public Result<?> forgetPwd() {
    	
        logger.info("忘记密码 ");

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
        
        

        PeopleExample example = new PeopleExample();
        example.createCriteria().andPeoplePhoneEqualTo(phone);
		List<People> userLst = userService.selectByExample(example);
        Assert.notEmpty(userLst, "用户不存在");


        People userDo = userLst.get(0);
        psw = MD5Encrypt.getMessageDigest(psw);
        userDo.setPeoplePassword(psw);
        int retUpdate= userService.updateByPrimaryKey(userDo);
        if(retUpdate==0){
        	return Result.failureResult("密码修改失败");
        }else{
        	return Result.successResult("密码修改成功");
        }
    }
  
}
