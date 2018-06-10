package com.kder.business.service.sms;

public interface KderSmsService {

	public abstract String smsSend( String content,
			String mobile) throws Throwable;

}