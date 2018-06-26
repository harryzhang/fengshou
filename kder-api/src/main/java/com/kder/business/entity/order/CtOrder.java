package com.kder.business.entity.order;

import java.math.BigDecimal;
import java.util.Date;

public class CtOrder implements java.io.Serializable {
	
	private String productName;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.order_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private Long orderId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.order_no
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private String orderNo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.prod_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private Long prodId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.user_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private Long userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.order_status
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private Integer orderStatus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.order_period
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private String orderPeriod;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.start_time
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private Date startTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.end_time
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private Date endTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.order_amt
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private BigDecimal orderAmt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.user_cert_no
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private String userCertNo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.user_cert_type
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private Integer userCertType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.user_address
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private String userAddress;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.user_name
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private String userName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.user_phone
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private String userPhone;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.recognizee_name
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private String recognizeeName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.recognizee_birth
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private Date recognizeeBirth;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.recognizee_cert_type
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private Integer recognizeeCertType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.recognizee_cert_no
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private String recognizeeCertNo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.recognizee_phone
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private String recognizeePhone;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.recognizee_address
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private String recognizeeAddress;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.recognizee_gender
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private String recognizeeGender;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.recognizee_security
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private String recognizeeSecurity;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.is_same
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private String isSame;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.sales_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private Long salesId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.sales_man
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private String salesMan;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.commission_amt
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private BigDecimal commissionAmt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.project_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private Long projectId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.audit_status
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private Integer auditStatus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.audit_date
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private Date auditDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.audit_instance_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private Long auditInstanceId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.private_cust_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private Long privateCustId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.create_time
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private Date createTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.update_time
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private Date updateTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.update_by
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private Long updateBy;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ct_order.create_by
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	private Long createBy;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.order_id
	 * @return  the value of ct_order.order_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.order_id
	 * @param orderId  the value for ct_order.order_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.order_no
	 * @return  the value of ct_order.order_no
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.order_no
	 * @param orderNo  the value for ct_order.order_no
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.prod_id
	 * @return  the value of ct_order.prod_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public Long getProdId() {
		return prodId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.prod_id
	 * @param prodId  the value for ct_order.prod_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.user_id
	 * @return  the value of ct_order.user_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.user_id
	 * @param userId  the value for ct_order.user_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.order_status
	 * @return  the value of ct_order.order_status
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public Integer getOrderStatus() {
		return orderStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.order_status
	 * @param orderStatus  the value for ct_order.order_status
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.order_period
	 * @return  the value of ct_order.order_period
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public String getOrderPeriod() {
		return orderPeriod;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.order_period
	 * @param orderPeriod  the value for ct_order.order_period
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setOrderPeriod(String orderPeriod) {
		this.orderPeriod = orderPeriod;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.start_time
	 * @return  the value of ct_order.start_time
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.start_time
	 * @param startTime  the value for ct_order.start_time
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.end_time
	 * @return  the value of ct_order.end_time
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.end_time
	 * @param endTime  the value for ct_order.end_time
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.order_amt
	 * @return  the value of ct_order.order_amt
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public BigDecimal getOrderAmt() {
		return orderAmt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.order_amt
	 * @param orderAmt  the value for ct_order.order_amt
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setOrderAmt(BigDecimal orderAmt) {
		this.orderAmt = orderAmt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.user_cert_no
	 * @return  the value of ct_order.user_cert_no
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public String getUserCertNo() {
		return userCertNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.user_cert_no
	 * @param userCertNo  the value for ct_order.user_cert_no
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setUserCertNo(String userCertNo) {
		this.userCertNo = userCertNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.user_cert_type
	 * @return  the value of ct_order.user_cert_type
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public Integer getUserCertType() {
		return userCertType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.user_cert_type
	 * @param userCertType  the value for ct_order.user_cert_type
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setUserCertType(Integer userCertType) {
		this.userCertType = userCertType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.user_address
	 * @return  the value of ct_order.user_address
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public String getUserAddress() {
		return userAddress;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.user_address
	 * @param userAddress  the value for ct_order.user_address
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.user_name
	 * @return  the value of ct_order.user_name
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.user_name
	 * @param userName  the value for ct_order.user_name
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.user_phone
	 * @return  the value of ct_order.user_phone
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public String getUserPhone() {
		return userPhone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.user_phone
	 * @param userPhone  the value for ct_order.user_phone
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.recognizee_name
	 * @return  the value of ct_order.recognizee_name
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public String getRecognizeeName() {
		return recognizeeName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.recognizee_name
	 * @param recognizeeName  the value for ct_order.recognizee_name
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setRecognizeeName(String recognizeeName) {
		this.recognizeeName = recognizeeName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.recognizee_birth
	 * @return  the value of ct_order.recognizee_birth
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public Date getRecognizeeBirth() {
		return recognizeeBirth;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.recognizee_birth
	 * @param recognizeeBirth  the value for ct_order.recognizee_birth
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setRecognizeeBirth(Date recognizeeBirth) {
		this.recognizeeBirth = recognizeeBirth;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.recognizee_cert_type
	 * @return  the value of ct_order.recognizee_cert_type
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public Integer getRecognizeeCertType() {
		return recognizeeCertType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.recognizee_cert_type
	 * @param recognizeeCertType  the value for ct_order.recognizee_cert_type
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setRecognizeeCertType(Integer recognizeeCertType) {
		this.recognizeeCertType = recognizeeCertType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.recognizee_cert_no
	 * @return  the value of ct_order.recognizee_cert_no
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public String getRecognizeeCertNo() {
		return recognizeeCertNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.recognizee_cert_no
	 * @param recognizeeCertNo  the value for ct_order.recognizee_cert_no
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setRecognizeeCertNo(String recognizeeCertNo) {
		this.recognizeeCertNo = recognizeeCertNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.recognizee_phone
	 * @return  the value of ct_order.recognizee_phone
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public String getRecognizeePhone() {
		return recognizeePhone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.recognizee_phone
	 * @param recognizeePhone  the value for ct_order.recognizee_phone
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setRecognizeePhone(String recognizeePhone) {
		this.recognizeePhone = recognizeePhone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.recognizee_address
	 * @return  the value of ct_order.recognizee_address
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public String getRecognizeeAddress() {
		return recognizeeAddress;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.recognizee_address
	 * @param recognizeeAddress  the value for ct_order.recognizee_address
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setRecognizeeAddress(String recognizeeAddress) {
		this.recognizeeAddress = recognizeeAddress;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.recognizee_gender
	 * @return  the value of ct_order.recognizee_gender
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public String getRecognizeeGender() {
		return recognizeeGender;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.recognizee_gender
	 * @param recognizeeGender  the value for ct_order.recognizee_gender
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setRecognizeeGender(String recognizeeGender) {
		this.recognizeeGender = recognizeeGender;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.recognizee_security
	 * @return  the value of ct_order.recognizee_security
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public String getRecognizeeSecurity() {
		return recognizeeSecurity;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.recognizee_security
	 * @param recognizeeSecurity  the value for ct_order.recognizee_security
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setRecognizeeSecurity(String recognizeeSecurity) {
		this.recognizeeSecurity = recognizeeSecurity;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.is_same
	 * @return  the value of ct_order.is_same
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public String getIsSame() {
		return isSame;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.is_same
	 * @param isSame  the value for ct_order.is_same
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setIsSame(String isSame) {
		this.isSame = isSame;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.sales_id
	 * @return  the value of ct_order.sales_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public Long getSalesId() {
		return salesId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.sales_id
	 * @param salesId  the value for ct_order.sales_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setSalesId(Long salesId) {
		this.salesId = salesId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.sales_man
	 * @return  the value of ct_order.sales_man
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public String getSalesMan() {
		return salesMan;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.sales_man
	 * @param salesMan  the value for ct_order.sales_man
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setSalesMan(String salesMan) {
		this.salesMan = salesMan;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.commission_amt
	 * @return  the value of ct_order.commission_amt
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public BigDecimal getCommissionAmt() {
		return commissionAmt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.commission_amt
	 * @param commissionAmt  the value for ct_order.commission_amt
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setCommissionAmt(BigDecimal commissionAmt) {
		this.commissionAmt = commissionAmt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.project_id
	 * @return  the value of ct_order.project_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.project_id
	 * @param projectId  the value for ct_order.project_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.audit_status
	 * @return  the value of ct_order.audit_status
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public Integer getAuditStatus() {
		return auditStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.audit_status
	 * @param auditStatus  the value for ct_order.audit_status
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.audit_date
	 * @return  the value of ct_order.audit_date
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public Date getAuditDate() {
		return auditDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.audit_date
	 * @param auditDate  the value for ct_order.audit_date
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.audit_instance_id
	 * @return  the value of ct_order.audit_instance_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public Long getAuditInstanceId() {
		return auditInstanceId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.audit_instance_id
	 * @param auditInstanceId  the value for ct_order.audit_instance_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setAuditInstanceId(Long auditInstanceId) {
		this.auditInstanceId = auditInstanceId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.private_cust_id
	 * @return  the value of ct_order.private_cust_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public Long getPrivateCustId() {
		return privateCustId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.private_cust_id
	 * @param privateCustId  the value for ct_order.private_cust_id
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setPrivateCustId(Long privateCustId) {
		this.privateCustId = privateCustId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.create_time
	 * @return  the value of ct_order.create_time
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.create_time
	 * @param createTime  the value for ct_order.create_time
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.update_time
	 * @return  the value of ct_order.update_time
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.update_time
	 * @param updateTime  the value for ct_order.update_time
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.update_by
	 * @return  the value of ct_order.update_by
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public Long getUpdateBy() {
		return updateBy;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.update_by
	 * @param updateBy  the value for ct_order.update_by
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ct_order.create_by
	 * @return  the value of ct_order.create_by
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public Long getCreateBy() {
		return createBy;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ct_order.create_by
	 * @param createBy  the value for ct_order.create_by
	 * @mbggenerated  Mon Jun 25 01:38:25 CST 2018
	 */
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	

}