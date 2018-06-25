/*
 * Powered By  huangzl QQ: 272950754
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2018
 */


package com.kder.business.action.order;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.kder.business.action.BaseAction;
import com.kder.business.common.CommonComboxConstants;
import com.kder.business.common.exception.BusinessException;
import com.kder.business.common.page.NewPagination;
import com.kder.business.common.page.PageDo;
import com.kder.business.common.page.PageDoUtil;
import com.kder.business.common.result.Result;
import com.kder.business.common.util.ExeclTools;
import com.kder.business.entity.order.CtOrder;
import com.kder.business.entity.order.CtOrderExample;
import com.kder.business.entity.privatecust.PrivateCustDo;
import com.kder.business.service.order.IOrderService;
import com.kder.business.service.privatecust.IPrivateCustService;



/**
 * @author  huangzl QQ: 272950754
 * @version 1.0
 * @since 1.0
 */

@Controller
@RequestMapping("/ctorder")
public class CtOrderController extends BaseAction{
	@Resource
	private IOrderService ctOrderService;
	@Resource
	private IPrivateCustService privateCustService;

	/**
     * 去列表页面
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model){
        return "ctorder/listCtOrder";
    }
	
	@RequestMapping("/listCtOrder")
    public void listCtOrder(NewPagination<CtOrder> pagination,
    							  ModelMap model,
    							  HttpServletResponse response) {

        logger.info("----listCtOrder----");
        try{
            PageDo<CtOrder> page = PageDoUtil.getPage(pagination);
            String searchUserName = getString("searchUserName");
            Map<String,Object> param = new HashMap<String,Object>();
            if(StringUtils.isNotBlank(searchUserName)){
                param.put("userName",searchUserName);
                model.addAttribute("searchUserName",searchUserName);
            }
            String searchRecognizeeName = getString("searchRecognizeeName");
            if(StringUtils.isNotBlank(searchRecognizeeName)){
                param.put("recognizeeName", searchRecognizeeName);
                model.addAttribute("searchRecognizeeName",searchRecognizeeName);
            }
            page = ctOrderService.getOrderPage(param, page);
            List<CommonComboxConstants> statusList = CommonComboxConstants.getStatusList();
            model.addAttribute("statusList", statusList);
            pagination = PageDoUtil.getPageValue(pagination, page);
            outPrint(response, JSONObject.toJSON(pagination));
        }catch(Exception e){
            logger.error("查询清单异常",e);
            throw new BusinessException("系统繁忙，请稍后再试");
        }
    }
	
	
	
	/**
     * 意向订单转订单页面
     *
     * @return
     */
    @RequestMapping("/convertOrder")
    public String convertOrder(ModelMap modelMap, 
    							HttpServletResponse response) {
        logger.info("----convertOrder----");
        try{
        	String privateCustId = this.getString("privateCustId");
            if(StringUtils.isNotBlank(privateCustId)){
            	//PrivateCustDo privateCustDo = privateCustService.getById(Long.valueOf(privateCustId));
            	CtOrderExample example = new CtOrderExample();
            	example.createCriteria().andPrivateCustIdEqualTo(Long.valueOf(privateCustId));
            	List<CtOrder> orderLst = ctOrderService.selectCtOrder(example );
            	CtOrder ctOrder = null;
            	if(orderLst != null && orderLst.size()>0){
	                ctOrder = orderLst.get(0);
            	}else{
            		ctOrder = new CtOrder();
	                ctOrder.setPrivateCustId(Long.valueOf(privateCustId));
            	}
            	modelMap.addAttribute("ctorder", ctOrder);
            }
            return "ctorder/addCtOrder";
        }catch(Exception e){
            logger.error("跳转到数据字典编辑页面异常",e);
            throw new BusinessException("系统繁忙，请稍后再试");
        }

    }
	
	
	  
    /**
     * 编辑页面
     *
     * @return
     */
    @RequestMapping("/addCtOrder")
    public String addCtOrder(String orderId, ModelMap modelMap, HttpServletResponse response) {
        logger.info("----addCtOrder----");
        try{
            if(StringUtils.isNotBlank(orderId)){
                CtOrder CtOrder = ctOrderService.getById(Long.valueOf(orderId));
                if(null != CtOrder){
                    modelMap.addAttribute("ctorder", CtOrder);
                }
            }
            return "ctorder/addCtOrder";
        }catch(Exception e){
            logger.error("跳转到数据字典编辑页面异常",e);
            throw new BusinessException("系统繁忙，请稍后再试");
        }

    }

    /**
     * 保存更新
     *
     * @return
     * @author: huangzlmf
     * @date: 2015年4月21日 12:49:05
     */
    @RequestMapping("/saveCtOrder")
    @ResponseBody
    public void saveCtOrder(CtOrder CtOrder, 
    							  HttpServletRequest request, 
    							  HttpServletResponse response) {
        logger.info("----saveCtOrder------");
        try{
            Long id = CtOrder.getOrderId();
            Long userId = new Long(this.getUserId());
            
            int i = 0;
            if (id != null && id.intValue()>0) {
            	CtOrder.setUpdateBy(userId);
            	CtOrder.setUpdateTime(new Date());
                i = ctOrderService.updateCtOrderById(CtOrder);
            } else {
				CtOrder.setCreateBy(userId);
            	CtOrder.setCreateTime(new Date());
            	
                i = ctOrderService.addCtOrder(CtOrder);
            }

            if (i <= 0) {
                outPrint(response,this.toJSONString(Result.failureResult("操作失败")));
                return;
            }
            outPrint(response, this.toJSONString(Result.successResult("操作成功")));
        }catch(Exception e){
            logger.error("保存更新失败",e);
            outPrint(response, this.toJSONString(Result.failureResult("操作失败")));
        }
        logger.info("----end saveCtOrder--------");
    }
    
	/**
     * 导出数据
     */
    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        try {
            Long time = System.currentTimeMillis();
            CtOrderExample example  = new CtOrderExample();
            String searchUserName = getString("searchUserName");
          
            if(StringUtils.isNotBlank(searchUserName)){
                example.createCriteria().andUserNameLike(searchUserName);
            }
            String searchRecognizeeName = getString("searchRecognizeeName");
            if(StringUtils.isNotBlank(searchRecognizeeName)){
            	example.createCriteria().andRecognizeeNameLike(searchRecognizeeName);
            }
            List<CtOrder> ctorderLst = ctOrderService.selectCtOrder(example);
            
            //导出类型： 保监会、保险协会、保险公司
            String exportType = getString("exportType");
            String excelHead = "数据导出";
            String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String fileName = URLEncoder.encode(excelHead + date + ".xls", "utf-8");
            List<String[]> excelheaderList = new ArrayList<String[]>();
            String[] excelheader = { "订单id", 
            						 "订单号", 
            						 "保险产品ID", 
            						 "用户ID", 
            						 "订单状态", 
            						 "保障期限", 
            						 "订单开始日期",
									 "订单结束日期",
									 "订单金额",
									 "投保人证件号码",
									 "投保人证件类别",
									 "投保人地址",
									 "投保人姓名",
									 "投保人手机号码",
									 "被保险人姓名",
									 "被保险人出身年月日",
									 "被保人证件类型",
									 "被保人证件号码",
									 "被保人电话",
									 "被保人地址",
									 "被保人性别",
									 "是否有社保",
									 "被保人和投保人是否同一人",
									 "销售人员ID",
									 "销售人员姓名",
									 "佣金",
									 "项目ID",
									 "审批状态",
									 "审批日期",
									 "意向订单ID",
									 "记录创建日期",
									 "记录更新日期"};
            excelheaderList.add(0, excelheader);
            String[] excelData = { "orderId", 
            					   "orderNo", 
            					   "prodId", 
            					   "userId", 
            					   "orderStatus", 
            					   "orderPeriod", 
            					   "startTime",
								   "endTime",
								   "orderAmt",
								   "userCertNo",
								   "userCertType",
								   "userAddress",
								   "userName",
								   "userPhone",
								   "recognizeeName",
								   "recognizeeBirth",
								   "recognizeeCertType",
								   "recognizeeCertNo",
								   "recognizeePhone",
								   "recognizeeAddress",
								   "recognizeeGender",
								   "recognizeeSecurity",
								   "isSame",
								   "salesId",
								   "salesMan",
								   "commissionAmt",
								   "projectId",
								   "auditStatus",
								   "auditDate",
								   "privateCustId",
								   "createTime",
								   "updateTime"};
            
            
            HSSFWorkbook wb = ExeclTools.execlExport(excelheaderList, excelData, excelHead, ctorderLst);
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            wb.write(response.getOutputStream());
            time = System.currentTimeMillis() - time;
            logger.info("导出数据，导出耗时(ms)：" + time);
        } catch (Exception e) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("下载失败");
            logger.error("导出数据，Excel下载失败", e);
            logger.error("导出数据异常", e);
            throw new BusinessException("系统繁忙，请稍后再试");
        } finally {
            response.flushBuffer();
        }

    }
	
}

