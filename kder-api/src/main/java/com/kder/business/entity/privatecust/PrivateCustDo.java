package com.kder.business.entity.privatecust;

import java.io.Serializable;
import java.util.Date;

public class PrivateCustDo implements Serializable {
	
	private Long  id;
	private String userName;
	private String phone;
	private String gender;
	private Integer status;
	private Date  createTime;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "PrivateCustDo [userName=" + userName + ", phone=" + phone
				+ ", gender=" + gender + ", status=" + status + ", createTime="
				+ createTime + "]";
	}
	
}
