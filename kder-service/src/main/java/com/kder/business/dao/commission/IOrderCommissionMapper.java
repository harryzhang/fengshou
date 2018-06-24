package com.kder.business.dao.commission;

import com.kder.business.entity.commission.OrderCommission;
import com.kder.business.entity.commission.OrderCommissionExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IOrderCommissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_commission
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    int countByExample(OrderCommissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_commission
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    int deleteByExample(OrderCommissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_commission
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_commission
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    int insert(OrderCommission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_commission
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    int insertSelective(OrderCommission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_commission
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    List<OrderCommission> selectByExample(OrderCommissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_commission
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    OrderCommission selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_commission
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    int updateByExampleSelective(@Param("record") OrderCommission record, @Param("example") OrderCommissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_commission
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    int updateByExample(@Param("record") OrderCommission record, @Param("example") OrderCommissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_commission
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    int updateByPrimaryKeySelective(OrderCommission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_commission
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    int updateByPrimaryKey(OrderCommission record);

	List<OrderCommission> queryListPage(Map<String, Object> param);
}