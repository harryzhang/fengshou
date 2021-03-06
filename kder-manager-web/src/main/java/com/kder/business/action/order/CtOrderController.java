/*
 * Powered By  huangzl QQ: 272950754
 * Web Site: http://www.hehenian.com
 * Since 2008 - 2018
 */


package com.kder.business.action.order;

import java.io.IOException;
import java.io.InputStream;
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
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.kder.business.action.BaseAction;
import com.kder.business.common.exception.BusinessException;
import com.kder.business.common.page.PageDo;
import com.kder.business.common.result.Result;
import com.kder.business.common.util.ExeclTools;
import com.kder.business.entity.order.CtOrder;
import com.kder.business.entity.order.CtOrderExample;
import com.kder.business.entity.privatecust.CtPrivateCust;
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
    public void listCtOrder(PageDo<CtOrder> page,
    							  ModelMap model,
    							  HttpServletResponse response) {

        logger.info("----listCtOrder----");
        try{
            Map<String, Object> param = buildQueryParameter();
            param.put("page", page);
            page = ctOrderService.getOrderPage(param);
            outPrint(response, JSONObject.toJSON(page));
        }catch(Exception e){
            logger.error("查询清单异常",e);
            throw new BusinessException("系统繁忙，请稍后再试");
        }
    }

	private Map<String, Object> buildQueryParameter() {
		String searchUserName = getString("searchUserName");
		Map<String,Object> param = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(searchUserName)){
		    param.put("userName",searchUserName);
		}
		String searchRecognizeeName = getString("searchRecognizeeName");
		if(StringUtils.isNotBlank(searchRecognizeeName)){
		    param.put("recognizeeName", searchRecognizeeName);
		}
		String searchOrderNo = getString("searchOrderNo");
		if(StringUtils.isNotBlank(searchOrderNo)){
			param.put("orderNo", searchOrderNo);
		}
		String searchMobile = getString("searchMobile");
		if(StringUtils.isNotBlank(searchMobile)){
			param.put("userPhone", searchMobile);
		}
		
		String searchStartTime = getString("searchStartTime");
		if(StringUtils.isNotBlank(searchStartTime)){
			param.put("createTime", searchStartTime);
		}
		String searchEndTime = getString("searchEndTime");
		if(StringUtils.isNotBlank(searchEndTime)){
			param.put("createTime", searchEndTime);
		}
		return param;
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
    public void saveCtOrder(CtOrder order, 
    							  HttpServletRequest request, 
    							  HttpServletResponse response) {
        logger.info("----saveCtOrder------");
        try{
            Long id = order.getOrderId();
            Long userId = new Long(this.getUserId());
            
            int i = 0;
            if (id != null && id.intValue()>0) {
            	order.setUpdateBy(userId);
            	order.setUpdateTime(new Date());
                i = ctOrderService.updateCtOrderById(order);
            } else {
				order.setCreateBy(userId);
            	order.setCreateTime(new Date());
            	
                i = ctOrderService.addCtOrder(order);
                
                //修改意向订单状态
                if(order.getPrivateCustId()!=null){
                	Long privateCustId = order.getPrivateCustId();
                	CtPrivateCust privCust = privateCustService.getById(privateCustId);
                	if(privCust != null &&privCust.getStatus() !=null&& 1 == privCust.getStatus().intValue()){
                		privCust.setStatus(3);
                		privateCustService.updateCtPrivateCustById(privCust);
                	}
                }
                
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
     * 导入表页面
     * @param model
     * @return
     */
    @RequestMapping("/toImport")
    public String toImport(Model model){
        return "ctorder/importOrder";
    }
    
    
	/**
     * 导入表页面
     * @param model
     * @return
     */
    @RequestMapping("/submitImport")
    @ResponseBody
    public void submitImport(Model model,
    						 @RequestParam MultipartFile importFile,
    						 HttpServletRequest request, 
    						 HttpServletResponse response){
    	
         
    	 logger.info("----submitImport------");
         try{
        	 String importFileName = importFile.getOriginalFilename();
        	 String importType = request.getParameter("importType");
        	 processExcell(importFile.getInputStream(),importFileName,importType);
        	 outPrint(response, this.toJSONString(Result.successResult("sucess")));
         }catch(Exception e){
             logger.error("保存更新失败",e);
             outPrint(response, this.toJSONString(Result.failureResult("error")));
         }
         logger.info("----end submitImport--------");
    }
    
	
	private void processExcell(InputStream input,String importFileName,String importType) throws IOException{
		Workbook wb = null;
		if(importFileName.contains("xlsx")){
			wb = new XSSFWorkbook(input);
		}else{
			wb = new HSSFWorkbook(input);
		}
		Sheet sheet =  wb.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();
		List<Map<String,Object>> sheetRows = new ArrayList<Map<String,Object>>();
		for(int rowIdx = 1 ; rowIdx <=lastRow; rowIdx++){
			
			Row row = sheet.getRow(rowIdx);
			short cells = row.getLastCellNum();
			Map<String,Object> parameterMap = new HashMap<String,Object>();
			for(short oneCell = 0 ; oneCell<cells ; oneCell++){
				String cellVal =  ExeclTools.processCellValue(row, oneCell);
				parameterMap.put("Column_"+(oneCell+1), cellVal);
			}
			sheetRows.add(parameterMap);
		}
		
		ctOrderService.importOrder(sheetRows,importFileName,importType,this.getUserId());			
	}
    
	/**
     * 导出数据
     */
    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        try {
            Long time = System.currentTimeMillis();

            Map<String, Object> param = buildQueryParameter();
            
            //导出类型： 保监会、保险协会、保险公司
            String exportType = getString("exportType");
            String exportTemplate = getString("exportTemplate");
            String policyType = "1";
            if("bxxh1".equals(exportTemplate)){
            	policyType  = "1";
    		}else if("bxxh2".equals(exportTemplate)){
    			policyType  = "2";
    		}else if("bxxh3".equals(exportTemplate)){
    			policyType  = "3";
    		}
            
            param.put("policyType", policyType);
            PageDo page = ctOrderService.getOrderPage(param);
            List<CtOrder> ctorderLst =page.getDatas();
            
            
            String excelHead = "数据导出";
            String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String fileName = URLEncoder.encode(excelHead + date + ".xls", "utf-8");
            List<String[]> excelheaderList = new ArrayList<String[]>();
            HSSFWorkbook wb = null;
            if("bxgs".equals(exportType)){
            	String[]excelData=buildBxgsHeader(excelheaderList); 
            	wb = ExeclTools.execlExport(excelheaderList, excelData, excelHead, ctorderLst);
    		}else if("bxxh".equals(exportType)){
    			if("bxxh1".equals(exportTemplate)){
        			String[]excelData=buildBxxhHeader1(excelheaderList); 
                	wb = ExeclTools.execlExport(excelheaderList, excelData, excelHead, ctorderLst);
        		}else if("bxxh2".equals(exportTemplate)){
        			String[]excelData=buildBxxhHeader2(excelheaderList); 
                	wb = ExeclTools.execlExport(excelheaderList, excelData, excelHead, ctorderLst);
        		}else if("bxxh3".equals(exportTemplate)){
        			String[]excelData=buildBxxhHeader3(excelheaderList); 
                	wb = ExeclTools.execlExport(excelheaderList, excelData, excelHead, ctorderLst);
        		}
    		}else if("bj".equals(exportType)){
    			 wb = new HSSFWorkbook(this.getClass().getResourceAsStream("man-template.xls"));
    		}
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

	private String[] buildBxxhHeader1(List<String[]> excelheaderList) {
		String[] excelheader = { "保险公司名称", 
				 "业务归属机构", 
				 "险种", 
				 "被保险人", 
				 "保单号", 
				 "起保日期", 
				 "终保日期",
				 "业务员",
				 "投保日期",
				 "单证号",
				 "标的号",
				 "标的名称",
				 "保费",
				 "代理费费率",
				 "代理费",
				 "业务员佣金率",
				 "业务员佣金",
				 "备注"};
		 excelheaderList.add(0, excelheader);
		 String[] excelData = { "policyCompany", 
			   "orgName", 
			   "policyType", 
			   "recognizeeName",
			   "orderNo",
			   "startTime", 
			   "endTime", 
			   "salesMan",
			   "createTime",
			   "billNo",
			   "productCode",
			   "productName",
			   "orderAmt",
			   "proxyRate",
			   "proxyFee",
			   "commissionRate",
			   "commissionAmt",
			   "remark"};
		 
		return excelData;
	}
	
	private String[] buildBxxhHeader2(List<String[]> excelheaderList) {
		String[] excelheader = { "保险公司名称", 
				 "业务归属机构", 
				 "被保险人",
				 "车牌号",
				 "业务员",
				 "投保日期",
				 "保单号/税号",
				 "产品名称",
				 "保费",
				 "代理费费率",
				 "代理费",
				 "业务员佣金率",
				 "业务员佣金",
				 "起保日期", 
				 "终保日期",
				 "备注"};
		 excelheaderList.add(0, excelheader);
		 String[] excelData = { "policyCompany", 
			   "orgName", 
			   "recognizeeName",
			   "cardNo",
			   "salesMan",
			   "createTime",
			   "orderNo",
			   "productName",
			   "orderAmt",
			   "proxyRate",
			   "proxyFee",
			   "commissionRate",
			   "commissionAmt",
			   "startTime", 
			   "endTime", 
			   "remark"};
		 
		return excelData;
	}
	
	private String[] buildBxxhHeader3(List<String[]> excelheaderList) {
		String[] excelheader = { "保险公司名称", 
				 "险种名称", 
				 "保单号", 
				 "所属机构", 
				 "被保险人数", 
				 "总保额",
				 "总保费",
				 "缴别",
				 "缴费年限",
				 "首期保费",
				 "续期保费",
				 "投保日期",
				 "起保日期", 
				 "终保日期",
				 "代理手续费费率",
				 "代理费",
				 "业务员佣金率",
				 "业务员佣金",
				 "业务员名称"};
		 excelheaderList.add(0, excelheader);
		 String[] excelData = { "policyCompany",
			   "policyType",
			   "orderNo",
			   "orgName", 
			   "policyManCnt",
			   "policyAmt",
			   "orderAmt",
			   "payType",
			   "payPeriod",
			   "firstPolicyFee",
			   "nextPolicyFee",
			   "createTime",
			   "startTime", 
			   "endTime", 
			   "proxyRate",
			   "proxyFee",
			   "commissionRate",
			   "commissionAmt",
			   "salesMan"};
		return excelData;
	}
	
	private String[] buildBJHeader(List<String[]> excelheaderList) {
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
		 
		return excelData;
	}
	
	
	private String[] buildBxgsHeader(List<String[]> excelheaderList) {
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
		 
		return excelData;
	}
	
}

