package com.kder.business.service.sms;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kder.business.common.exception.BusinessException;
import com.kder.business.common.util.IdentifyCodeGenerator;
import com.kder.business.dao.sms.ISmsDao;
import com.kder.business.dao.user.PeopleMapper;
import com.kder.business.entity.sms.SmsDo;
import com.kder.business.entity.user.People;

@Service("smsService")
public class SmsServiceImpl implements ISmsService{
	
	Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);
	
	@Resource
	private PeopleMapper userDao;
	
	@Resource 
	private ISmsDao smsDao;
	
	@Resource
	private KderSmsService kderSmsImpl;
	
	/*
	 * page： (non-Javadoc) 页面
	 * @see com.kder.business.service.sms.ISmsService#send(java.lang.Integer, java.lang.String)
	 */
	@Override
	public void send(Integer userId, String page) {
		People user = userDao.selectByPrimaryKey(userId);
		try {
			if(StringUtils.isEmpty(user.getPeoplePhone())){
				new BusinessException("你还未设置手机号码");
			}
			
		} catch (Throwable e) {
			logger.error(e.getMessage());
			throw new BusinessException("发送失败");
		}
		
		send(user.getPeoplePhone(),page);
		
	}

	
	/*
	 * page： (non-Javadoc) 页面
	 * @see com.kder.business.service.sms.ISmsService#send(java.lang.Integer, java.lang.String)
	 */
	@Override
	public void send(String mobile, String page) {
		try {
			String smscode = IdentifyCodeGenerator.generateIdentifyCode(4);
			logger.debug("发送手机号码：{}",mobile);
			String smsTemplate = getSmsTemplateByPage(page);
			String smsSendBizId = kderSmsImpl.smsSend(smscode, mobile,smsTemplate);
			logger.debug("send:"+smsSendBizId);
			
			SmsDo record = new SmsDo();
			record.setRecievers(mobile);
			record.setMessage(smscode);
			record.setBusinessType(page);
			record.setSendId(smsSendBizId);
			smsDao.insertSelective(record);
			
		} catch (Throwable e) {
			logger.error(e.getMessage());
			throw new BusinessException("发送失败");
		}		
	}
	
	private String getSmsTemplateByPage(String page){
		if("register".equalsIgnoreCase(page)){
			return SmsTemplate.SMS_TEMPLATE_REG;
		}
		if("login".equalsIgnoreCase(page)){
			return SmsTemplate.SMS_TEMPLATE_LOGIN;
		}
		if("changePage".equalsIgnoreCase(page)){
			return SmsTemplate.SMS_TEMPLATE_CHANGE_PWD;
		}
		if("changeInfo".equalsIgnoreCase(page)){
			return SmsTemplate.SMS_TEMPLATE_CHANGE_INFO;
		}
		if("cert".equalsIgnoreCase(page)){
			return SmsTemplate.SMS_TEMPLATE_CERT;
		}
		return "";
	}
	
	@Override
	public boolean checkSms(Integer userId, String page, String smsCode) {
		People user = userDao.selectByPrimaryKey(userId);
		return checkSms(user.getPeoplePhone(),page,smsCode);
	}

	
	@Override
	public boolean checkSms(String mobile, String page, String smsCode) {
		SmsDo smsDo = smsDao.getLastIdentifyCode(mobile,page);
		return smsCode.equals(smsDo.getMessage());
	}
}
