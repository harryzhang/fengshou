package com.kder.business.service.sms;


public interface ISmsService {

	/**
	 * 发送短信验证码
	 * @param userId
	 * @param page
	 */
	void send(Integer userId, String page);

	public abstract boolean checkSms(String mobile, String page, String smsCode);

	public abstract void send(String mobile, String page);

	/**
	 * 验证短信验证码
	 * @param userId
	 * @param page
	 * @param smsCode
	 * @return
	 */
	boolean checkSms(Integer userId, String page, String smsCode);

}
