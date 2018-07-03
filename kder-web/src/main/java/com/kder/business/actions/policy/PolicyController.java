package com.kder.business.actions.policy;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kder.business.actions.common.BaseController;
import com.kder.business.common.exception.BusinessException;
import com.kder.business.common.result.Result;
import com.kder.business.common.util.DateUtil;
import com.kder.business.entity.order.CtOrder;
import com.kder.business.entity.order.CtOrderExample;
import com.kder.business.entity.product.TFsInsuranceWithBLOBs;
import com.kder.business.service.order.IOrderService;
import com.kder.business.service.product.IFsInsuranceService;


@RestController
@RequestMapping("/policy")
public class PolicyController extends BaseController {
	
	@Resource
	IOrderService orderService;
	
	@Resource
	IFsInsuranceService productService;
	
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
    public  Result<?>  submitPolicy() {
    	
         try{
         	CtOrder newCtOrder = makeOrder();
         	logger.info("userId:"+this.getUserId());
         	if(null == this.getUserId()){
         		return Result.failureResult("请先登录");
         	}
         	Long userId = Long.valueOf(this.getUserId());
         	newCtOrder.setUserId(userId);
         	newCtOrder.setCreateBy(userId);
         	CtOrderExample example = new CtOrderExample();
         	example.createCriteria().andUserIdEqualTo(userId);
         	example.createCriteria().andProdIdEqualTo(newCtOrder.getProdId());
         	example.createCriteria().andOrderStatusEqualTo(1);//草稿状态
			List<CtOrder> ordLst = orderService.selectCtOrder(example);
			int i = 0;
			if(ordLst != null && ordLst.size()>0){
				newCtOrder.setOrderId(ordLst.get(0).getOrderId());
				i = orderService.updateCtOrderById(newCtOrder);
			}else{
				i = orderService.addCtOrder(newCtOrder);
			}
         	
         	if(i>0){
         		return Result.successResult("提交成功");
         	}else{
         		return Result.failureResult("提交失败");
         	}
         }catch(BusinessException e){
         	Result<?> result = Result.failureResult(e.getMessage());
         	 return result;
         }
    }
    
    
    /**
     * name:方式
		credType:0
		idNo:1235555563565
		mobile:13692177359
		area:
		areaValue:
		same:false
		deadline:364
		policyholderMobile:
		relationshipType:1
		insuranceRadio:1
		
		protectName:天天
		protectIdNo:121345454545
		protectMobile:131313454545
     * @return
     */
    private CtOrder makeOrder() {
    	String productId = getString("productId");//产品
    	String name = getString("name");//投保人姓名
    	String credType = getString("credType");//证件类型
    	String idNo = getString("idNo");//身份证号码
    	String mobile = getString("mobile");//投保人手机号码
    	String area = getString("area");//地址
    	String areaValue = getString("areaValue"); //地址
    	String same = getString("same");//投保和被保是否同一人
    	String date = getString("date");//投保起止日期
    	
    	String deadline = getString("deadline");//保险期限
    	String relationshipType = getString("relationshipType");//关系
    	String insuranceRadio = getString("insuranceRadio");//是否有社保
    	//被保人
    	String protectName = getString("protectName"); //姓名
    	String protectIdNo = getString("protectIdNo"); //身份证号码
    	String protectMobile = getString("protectMobile"); //手机号码

    	CtOrder newCtOrder = new CtOrder();
    	
    	if(StringUtils.isNotBlank(productId)){
    		newCtOrder.setProdId(Long.valueOf(productId));    		
    	}
    	if(StringUtils.isNotBlank(name)){
    		newCtOrder.setUserName(name);    		
    	}
    	if(StringUtils.isNotBlank(credType)){
    		newCtOrder.setUserCertType(Integer.valueOf(credType));
    		newCtOrder.setRecognizeeCertType(Integer.valueOf(credType));
    	}
    	if(StringUtils.isNotBlank(idNo)){
    		newCtOrder.setUserCertNo(idNo);    		
    	}
    	if(StringUtils.isNotBlank(mobile)){
    		newCtOrder.setUserPhone(mobile);    		
    	}
    	if(StringUtils.isNotBlank(same)){
    		newCtOrder.setIsSame(same);    		
    	}
    	if(StringUtils.isNotBlank(same)){
    		newCtOrder.setIsSame(same);    		
    	}
    	if(StringUtils.isNotBlank(areaValue)){
    		newCtOrder.setUserAddress(areaValue);    		
    	}
    	if(StringUtils.isNotBlank(deadline)){
    		newCtOrder.setOrderPeriod(deadline);    		
    	}
    	if(StringUtils.isNotBlank(insuranceRadio)){
    		newCtOrder.setRecognizeeSecurity(insuranceRadio);    		
    	}
    	if(StringUtils.isNotBlank(protectName)){
    		newCtOrder.setRecognizeeName(protectName);    		
    	}
    	if(StringUtils.isNotBlank(protectIdNo)){
    		newCtOrder.setRecognizeeCertNo(protectIdNo);    		
    	}
    	if(StringUtils.isNotBlank(protectMobile)){
    		newCtOrder.setRecognizeePhone(protectMobile);    		
    	}

    	newCtOrder.setStartTime(new Date());
    	newCtOrder.setEndTime(DateUtil.addDays(newCtOrder.getStartTime(), Integer.valueOf(deadline))); 
    	
    	if("true".equals(same)){
    		newCtOrder.setRecognizeePhone(mobile);
    		newCtOrder.setRecognizeeCertNo(idNo);    
    		newCtOrder.setRecognizeeName(name); 
    	}
    	TFsInsuranceWithBLOBs productDo = productService.getById(Long.valueOf(productId));
    	newCtOrder.setProductName(productDo.getTitle());
    	newCtOrder.setOrderAmt(productDo.getStartPrice());
    	return newCtOrder;
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
