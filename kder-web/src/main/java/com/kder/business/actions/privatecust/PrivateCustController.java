package com.kder.business.actions.privatecust;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kder.business.actions.common.BaseController;
import com.kder.business.common.result.Result;
import com.kder.business.entity.privatecust.CtPrivateCust;
import com.kder.business.service.privatecust.IPrivateCustService;
import com.kder.web.util.TokenUtil;


/** 
 * 私人定制
 * @author harryzhang
 * @date 2018年3月24日 
 * @version v1.0
 */
@RestController
@RequestMapping("/privatecust")
public class PrivateCustController extends BaseController {

	private final static Logger logger = Logger.getLogger(PrivateCustController.class);
	
	@Resource
	private IPrivateCustService privateCustService;
	

    /**
     * 提交私人定制信息 
     * @param request
     * @param response
     * @return  
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result<?> create() {
    	
    	String userName = getString("userName");
    	String phone = getString("phone");
        String gender = getString("gender");
        Assert.hasText(userName, "请输入用户名");
        Assert.hasText(phone, "请输入手机号码");
        logger.info("私人订制, userName:" + userName + "; phone:" + phone);
        
        CtPrivateCust privateCust = new CtPrivateCust();
        privateCust.setUserName(userName);
        privateCust.setPhone(phone);
        privateCust.setGender(gender);        
        privateCustService.addCtPrivateCust(privateCust);
        
        String token = TokenUtil.getTokenNoSave();
        this.saveToken(token);
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        return Result.successResult("私人定制提交成功", map);
    }

    
}
