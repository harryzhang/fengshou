package com.kder.business.service.sms;

public interface KderSmsService {

	String smsSend( String mobile,String content,String smsTemplate) throws Exception;

}