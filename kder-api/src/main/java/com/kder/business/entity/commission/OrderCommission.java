package com.kder.business.entity.commission;

import java.math.BigDecimal;
import java.util.Date;

public class OrderCommission implements java.io.Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_commission.id
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_commission.user_id
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_commission.order_id
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    private Long orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_commission.user_name
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_commission.commission_amt
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    private BigDecimal commissionAmt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_commission.order_no
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    private String orderNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_commission.status
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_commission.audit_status
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    private Integer auditStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_commission.audit_time
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    private Date auditTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_commission.audit_id
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    private Long auditId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_commission.create_by
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    private Long createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_commission.create_time
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_commission.update_time
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_commission.update_by
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    private Long updateBy;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_commission.id
     *
     * @return the value of t_order_commission.id
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_commission.id
     *
     * @param id the value for t_order_commission.id
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_commission.user_id
     *
     * @return the value of t_order_commission.user_id
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_commission.user_id
     *
     * @param userId the value for t_order_commission.user_id
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_commission.order_id
     *
     * @return the value of t_order_commission.order_id
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_commission.order_id
     *
     * @param orderId the value for t_order_commission.order_id
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_commission.user_name
     *
     * @return the value of t_order_commission.user_name
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_commission.user_name
     *
     * @param userName the value for t_order_commission.user_name
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_commission.commission_amt
     *
     * @return the value of t_order_commission.commission_amt
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public BigDecimal getCommissionAmt() {
        return commissionAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_commission.commission_amt
     *
     * @param commissionAmt the value for t_order_commission.commission_amt
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public void setCommissionAmt(BigDecimal commissionAmt) {
        this.commissionAmt = commissionAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_commission.order_no
     *
     * @return the value of t_order_commission.order_no
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_commission.order_no
     *
     * @param orderNo the value for t_order_commission.order_no
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_commission.status
     *
     * @return the value of t_order_commission.status
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_commission.status
     *
     * @param status the value for t_order_commission.status
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_commission.audit_status
     *
     * @return the value of t_order_commission.audit_status
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_commission.audit_status
     *
     * @param auditStatus the value for t_order_commission.audit_status
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_commission.audit_time
     *
     * @return the value of t_order_commission.audit_time
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_commission.audit_time
     *
     * @param auditTime the value for t_order_commission.audit_time
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_commission.audit_id
     *
     * @return the value of t_order_commission.audit_id
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public Long getAuditId() {
        return auditId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_commission.audit_id
     *
     * @param auditId the value for t_order_commission.audit_id
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_commission.create_by
     *
     * @return the value of t_order_commission.create_by
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_commission.create_by
     *
     * @param createBy the value for t_order_commission.create_by
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_commission.create_time
     *
     * @return the value of t_order_commission.create_time
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_commission.create_time
     *
     * @param createTime the value for t_order_commission.create_time
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_commission.update_time
     *
     * @return the value of t_order_commission.update_time
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_commission.update_time
     *
     * @param updateTime the value for t_order_commission.update_time
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_commission.update_by
     *
     * @return the value of t_order_commission.update_by
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_commission.update_by
     *
     * @param updateBy the value for t_order_commission.update_by
     *
     * @mbggenerated Mon Jun 25 02:22:59 CST 2018
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }
}