package com.kder.business.dao.order;

import com.kder.business.entity.order.CtOrder;
import com.kder.business.entity.order.CtOrderExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CtOrderMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ct_order
	 * @mbggenerated  Sun Jul 01 13:48:22 CST 2018
	 */
	int countByExample(CtOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ct_order
	 * @mbggenerated  Sun Jul 01 13:48:22 CST 2018
	 */
	int deleteByExample(CtOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ct_order
	 * @mbggenerated  Sun Jul 01 13:48:22 CST 2018
	 */
	int deleteByPrimaryKey(Long orderId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ct_order
	 * @mbggenerated  Sun Jul 01 13:48:22 CST 2018
	 */
	int insert(CtOrder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ct_order
	 * @mbggenerated  Sun Jul 01 13:48:22 CST 2018
	 */
	int insertSelective(CtOrder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ct_order
	 * @mbggenerated  Sun Jul 01 13:48:22 CST 2018
	 */
	List<CtOrder> selectByExample(CtOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ct_order
	 * @mbggenerated  Sun Jul 01 13:48:22 CST 2018
	 */
	CtOrder selectByPrimaryKey(Long orderId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ct_order
	 * @mbggenerated  Sun Jul 01 13:48:22 CST 2018
	 */
	int updateByExampleSelective(@Param("record") CtOrder record,
			@Param("example") CtOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ct_order
	 * @mbggenerated  Sun Jul 01 13:48:22 CST 2018
	 */
	int updateByExample(@Param("record") CtOrder record,
			@Param("example") CtOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ct_order
	 * @mbggenerated  Sun Jul 01 13:48:22 CST 2018
	 */
	int updateByPrimaryKeySelective(CtOrder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ct_order
	 * @mbggenerated  Sun Jul 01 13:48:22 CST 2018
	 */
	int updateByPrimaryKey(CtOrder record);

	/**
	 * 分页查询
	 * @param param
	 * @return
	 */
	List<CtOrder> queryListPage(Map<String, Object> param);

	/**
	 * 导入明细
	 * @param oneRow
	 */
	void importOrder(Map<String, Object> oneRow);

	/**
	 * 导入主表
	 * @param importLog
	 */
	void insertImportLog(Map<String, Object> importLog);
}