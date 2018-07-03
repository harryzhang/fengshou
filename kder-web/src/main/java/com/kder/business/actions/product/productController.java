/*
 * Powered By  huangzl QQ: 272950754
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2018
 */


package com.kder.business.actions.product;

import javax.annotation.Resource;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kder.business.actions.common.BaseController;
import com.kder.business.common.exception.BusinessException;
import com.kder.business.common.result.Result;
import com.kder.business.entity.product.TFsInsuranceWithBLOBs;
import com.kder.business.service.product.IFsInsuranceService;



/**
 * @author  huangzl QQ: 272950754
 * @version 1.0
 * @since 1.0
 */

@RestController
@RequestMapping("/product")
public class productController extends BaseController{
	
	@Resource
	private IFsInsuranceService fsInsuranceService;
	

    /**
     * 
     * @return
     */
    @RequestMapping(value = "/getProductById", method = RequestMethod.POST)
    public Result<?> getProductById() {
    	

        String insId = getString("insId");
        Assert.hasText(insId, "产品id不能为空");
        Result result = Result.successResult("获取成功");
        try{
        	TFsInsuranceWithBLOBs productDo = fsInsuranceService.getById(Long.valueOf(insId));
        	result.setData(productDo);
            return result;
        }catch(BusinessException e){
        	result = Result.failureResult(e.getMessage());
        	 return result;
        }
    }
	
}

