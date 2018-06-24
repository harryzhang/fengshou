package com.kder.business.service.dict;

import java.util.List;
import java.util.Map;

import com.kder.business.common.page.PageDo;
import com.kder.business.entity.dict.LoanDictDo;
import com.kder.business.entity.dict.LoanDictDtlDo;

public interface IDictService {

    /**
     * 查询单个字典明细信息<br/>
     * 并且状态有效
     * 
     * @param dictCode 字典编码
     * @param dictDtlCode 字典明细编码
     * @return
     */
    LoanDictDtlDo getLoanDictDtl(String dictCode, String dictDtlCode);

    LoanDictDo getDictById(long dictId);

    /**
     * 查询单个字典明细信息<br/>
     * 并且状态有效
     * 
     * @param dictId 字典主表的id
     * @param dictDtlCode 字典明细编码
     * @return
     */
    LoanDictDtlDo getLoanDictDtl(Long dictId, String dictDtlCode);

    /**
     * 通过code查询字典t_loan_dict 
     * 并且状态有效
     * 
     * @param dictCode 字典编码
     * @return
     */
    LoanDictDo getLoanDict(String dictCode);
    
    LoanDictDtlDo getLoanDictDtl(String dictCode);

    List<LoanDictDtlDo> queryDictDtlListByDictCode(String dictCode);

    List<LoanDictDtlDo> getDictDetailByDictId(Long dictId);


    /**
     * 更新数据字典明细
     * @param dictDtlDo
     * @return
     */
    int updateDictDtl(LoanDictDtlDo dictDtlDo);

    /**
     * 新增数据字典明细
     * @param dictDtlDo
     * @return
     */
    int addDictDtl(LoanDictDtlDo dictDtlDo);

    int addDict(LoanDictDo loanDictDo);

    int updateDict(LoanDictDo loanDictDo);

    List<LoanDictDtlDo> getDictDetail(Map<String, Object> param);
    
	LoanDictDtlDo getLoanDictDtlByDictDtlCode(String dictDtlCode);
	
	void updateDictDtlRemark(List<LoanDictDtlDo> list);
	
	/**
     * 查询所有字典记录及其子记录
     * @return
     */
    List<LoanDictDo> selectLoanDictLinkDtl();
    
 

    /**
     * 分页查询
     * @param param
     * @param page
     * @return
     */
	PageDo<LoanDictDo> getLoanDictPage(Map<String, Object> param,
			PageDo<LoanDictDo> page);
}
