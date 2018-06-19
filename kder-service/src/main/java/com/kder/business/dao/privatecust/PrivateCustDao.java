package com.kder.business.dao.privatecust;

import com.kder.business.entity.privatecust.PrivateCustDo;
import com.kder.business.entity.privatecust.CtPrivateCustExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrivateCustDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ct_private_cust
     *
     * @mbggenerated Mon Jun 11 13:04:06 CST 2018
     */
    int countByExample(CtPrivateCustExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ct_private_cust
     *
     * @mbggenerated Mon Jun 11 13:04:06 CST 2018
     */
    int deleteByExample(CtPrivateCustExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ct_private_cust
     *
     * @mbggenerated Mon Jun 11 13:04:06 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ct_private_cust
     *
     * @mbggenerated Mon Jun 11 13:04:06 CST 2018
     */
    int insert(PrivateCustDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ct_private_cust
     *
     * @mbggenerated Mon Jun 11 13:04:06 CST 2018
     */
    int insertSelective(PrivateCustDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ct_private_cust
     *
     * @mbggenerated Mon Jun 11 13:04:06 CST 2018
     */
    List<PrivateCustDo> selectByExample(CtPrivateCustExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ct_private_cust
     *
     * @mbggenerated Mon Jun 11 13:04:06 CST 2018
     */
    PrivateCustDo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ct_private_cust
     *
     * @mbggenerated Mon Jun 11 13:04:06 CST 2018
     */
    int updateByExampleSelective(@Param("record") PrivateCustDo record, @Param("example") CtPrivateCustExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ct_private_cust
     *
     * @mbggenerated Mon Jun 11 13:04:06 CST 2018
     */
    int updateByExample(@Param("record") PrivateCustDo record, @Param("example") CtPrivateCustExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ct_private_cust
     *
     * @mbggenerated Mon Jun 11 13:04:06 CST 2018
     */
    int updateByPrimaryKeySelective(PrivateCustDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ct_private_cust
     *
     * @mbggenerated Mon Jun 11 13:04:06 CST 2018
     */
    int updateByPrimaryKey(PrivateCustDo record);
}