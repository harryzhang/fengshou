package com.kder.business.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.kder.business.common.exception.BusinessException;
import com.kder.business.common.result.Result;
import com.kder.business.dao.user.PeopleMapper;
import com.kder.business.entity.user.People;
import com.kder.business.entity.user.PeopleExample;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Resource
    private PeopleMapper userDao;
	
	public int countByExample(PeopleExample example){
		return userDao.countByExample(example);
	}

	
	public int deleteByExample(PeopleExample example){
		return userDao.deleteByExample(example);
	}

	
	public int deleteByPrimaryKey(Integer peopleId){
		return userDao.deleteByPrimaryKey(peopleId);
	}

	
	public int insert(People record){
		return userDao.insert(record);
	}

	public int insertSelective(People record){
		return userDao.insertSelective(record);
	}

	
	public List<People> selectByExample(PeopleExample example){
		return userDao.selectByExample(example);
	}

	
	public People selectByPrimaryKey(Integer peopleId){
		return userDao.selectByPrimaryKey(peopleId);
	}

	
	public int updateByExampleSelective(@Param("record") People record,
			@Param("example") PeopleExample example){
		return userDao.updateByExampleSelective(record, example);
	}

	
	public int updateByExample(@Param("record") People record,
			@Param("example") PeopleExample example){
		return userDao.updateByExample(record, example);
	}

	
	public int updateByPrimaryKeySelective(People record){
		return userDao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(People record){
		return userDao.updateByPrimaryKey(record);
	}


	@Override
	public Result<?> reg(People userDo) {
		
		logger.info("regUser:", userDo);
		userDo.setPeopleState(0);
		userDo.setPeopleAppId(1);
		
		PeopleExample example = new PeopleExample();
		example.createCriteria().andPeoplePhoneEqualTo(userDo.getPeoplePhone());
		List<People> pList = userDao.selectByExample(example );
		if(pList != null && !pList.isEmpty()){
			throw new BusinessException("注册失败用户已存在", "user.reg001");
		}
		
		int ret = userDao.insertSelective(userDo);
		if(ret < 1){
			throw new BusinessException("注册失败", "user.reg002");
		}
		return Result.successResult("注册成功",userDo);
	}

    
}
