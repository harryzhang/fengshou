package com.kder.business.service.privatecust;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kder.business.dao.privatecust.PrivateCustDao;
import com.kder.business.entity.privatecust.PrivateCustDo;

@Service("privateCustService")
public class PrivateCustServiceImpl implements IPrivateCustService {

	@Resource
	PrivateCustDao privateCustDao;
	
	@Override
	public int create(PrivateCustDo privateCust) {
		privateCust.setCreateTime(new Date());
		return privateCustDao.insertSelective(privateCust);
	}

}
