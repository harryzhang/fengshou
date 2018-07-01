package com.kder.business.action.dict;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.kder.business.action.BaseAction;
import com.kder.business.common.CommonComboxConstants;
import com.kder.business.common.exception.BusinessException;
import com.kder.business.common.page.PageDo;
import com.kder.business.common.result.Result;
import com.kder.business.entity.dict.LoanDictDo;
import com.kder.business.entity.dict.LoanDictDtlDo;
import com.kder.business.service.dict.IDictService;


@Controller
@RequestMapping("/dict")
public class DictController extends BaseAction{

    @Autowired
    private IDictService dictService;

    /**
     * 去数据字典的列表页面
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model){
        logger.info("dict list");
        return "dict/listDict";
    }


    /**
     * 查询数据字典做页面的列表
     * @param response
     */
    @RequestMapping("/combox")
    public void agentTypeList( HttpServletRequest request,HttpServletResponse response){
        try{
            String code = this.getString(request, "dictCode");
            LoanDictDtlDo chooseDtl = new LoanDictDtlDo();
            chooseDtl.setCode("");
            chooseDtl.setName("请选择");
            chooseDtl.setRemark("请选择");
            List<LoanDictDtlDo> dictDtlLst = null;
            if(StringUtils.isNotBlank(code)){
                dictDtlLst = dictService.queryDictDtlListByDictCode(code);
            }else{
                dictDtlLst = new ArrayList<LoanDictDtlDo>(1);
            }
            dictDtlLst.add(0, chooseDtl);
            outPrint(response, JSONObject.toJSON(dictDtlLst));
        }catch(Exception e){
            logger.error("查询数据字典做页面的列表异常",e);
        }
    }

    /**
     * 查询数据字典明细
     *
     * @return
     */
    @RequestMapping("/listDictDetail")
    public void listDictDetail(ModelMap model,HttpServletResponse response) {

        logger.info("----listDictDetail----");
        try{
            String dictId = getString("dictId");
            if(StringUtils.isNotBlank(dictId)){
                List<LoanDictDtlDo> dictDetaiList = dictService.getDictDetailByDictId(Long.valueOf(dictId));
                outPrint(response, JSONObject.toJSON(dictDetaiList));
            }else{
                outPrint(response, JSONObject.toJSON(Collections.EMPTY_LIST));
            }
        }catch(Exception e){
            logger.error("查询数据字典明细异常",e);
            throw new BusinessException("系统繁忙，请稍后再试");
        }
    }

    /**
     * 查询清单
     *
     * @return
     */
    @RequestMapping("/listDict")
    public void listDict(PageDo<LoanDictDo> page,ModelMap model,HttpServletResponse response) {

        logger.info("----listDict----");
        try{
            String dictName = getString("searchStr");
            Map<String,Object> param = new HashMap<String,Object>();
            if(StringUtils.isNotBlank(dictName)){
                param.put("name", "%"+dictName+"%");
                model.addAttribute("searchStr",dictName);
            }
            String dictCode = getString("searchCodeStr");
            if(StringUtils.isNotBlank(dictCode)){
                param.put("code", "%"+dictCode+"%");
                model.addAttribute("searchCodeStr",dictCode);
            }
            page = dictService.getLoanDictPage(param, page);
            List<CommonComboxConstants> statusList = CommonComboxConstants.getStatusList();
            model.addAttribute("statusList", statusList);
            outPrint(response, JSONObject.toJSON(page));
        }catch(Exception e){
            logger.error("数据字典 查询清单异常",e);
            throw new BusinessException("系统繁忙，请稍后再试");
        }
    }

    /**
     * 数据字典编辑页面
     *
     * @return
     */
    @RequestMapping("/addDict")
    public String addDict(String id, ModelMap modelMap, HttpServletResponse response) {
        logger.info("----addDict----");
        try{
            if(StringUtils.isNotBlank(id)){
                LoanDictDo dictDo = dictService.getDictById(Long.valueOf(id));
                if(null != dictDo){
                    modelMap.addAttribute("dictDo", dictDo);
                }
            }
            return "/dict/addDict";
        }catch(Exception e){
            logger.error("跳转到数据字典编辑页面异常",e);
            throw new BusinessException("系统繁忙，请稍后再试");
        }

    }

    /**
     * 数据字典保存更新
     *
     * @return
     * @author: huangzlmf
     * @date: 2015年4月21日 12:49:05
     */
    @RequestMapping("/saveDict")
    @ResponseBody
    public void saveDict(LoanDictDo dictDo, HttpServletRequest request, HttpServletResponse response) {
        logger.info("----saveDict------");
        try{
            Map<String, Object> parameterMap = new HashMap<String, Object>();
            int i = 0;
            Long id = dictDo.getId();
            Long userId = new Long(this.getUserId());
            dictDo.setCreateUserId(userId);
            dictDo.setUpdateUserId(userId);
            if (id != null && id.intValue()>0) {
                i = dictService.updateDict(dictDo);
            } else {
                i = dictService.addDict(dictDo);
            }

            if (i <= 0) {
                outPrint(response,this.toJSONString(Result.failureResult("操作失败")));
                return;
            }
            outPrint(response, this.toJSONString(Result.successResult("操作成功")));
        }catch(Exception e){
            logger.error("数据字典保存更新异常",e);
            outPrint(response, this.toJSONString(Result.failureResult("操作失败")));
        }
        logger.info("----end saveDict--------");


    }

    /**
     * 数据字典明细保存更新
     *
     * @return
     * @author: huangzlmf
     * @date: 2015年4月21日 12:49:05
     */
    @RequestMapping("/saveDictDetail")
    @ResponseBody
    public void saveDictDetail(LoanDictDtlDo dictDtlDo, HttpServletRequest request, HttpServletResponse response) {
        logger.info("----saveDictDetail------");
        try{
            Map<String, Object> parameterMap = new HashMap<String, Object>();
            int i = 0;
            Long id = dictDtlDo.getId();
            if (id != null && id.intValue()>0) {
                i = dictService.updateDictDtl(dictDtlDo);
            } else {
                i = dictService.addDictDtl(dictDtlDo);
            }

            if (i <= 0) {
                outPrint(response,this.toJSONString(Result.failureResult("操作失败")));
                return;
            }
            outPrint(response, this.toJSONString(Result.successResult("操作成功")));

        }catch(Exception e){
           logger.error("数据字典明细保存更新异常",e);
            outPrint(response, this.toJSONString(Result.failureResult("操作失败")));
        }
        logger.info("----end saveDictDetail--------");
    }
}