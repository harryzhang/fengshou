package com.kder.business.service.user;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kder.business.common.constant.Constants;
import com.kder.business.common.exception.BusinessException;
import com.kder.business.common.page.PageDo;
import com.kder.business.common.result.Result;
import com.kder.business.dao.user.PeopleMapper;
import com.kder.business.entity.order.CtOrder;
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
		record.setPeopleAppId(1);
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
		record.setPeopleAppId(1);
		return userDao.updateByExampleSelective(record, example);
	}

	
	public int updateByExample(@Param("record") People record,
			@Param("example") PeopleExample example){
		record.setPeopleAppId(1);
		return userDao.updateByExample(record, example);
	}

	
	public int updateByPrimaryKeySelective(People record){
		record.setPeopleAppId(1);
		return userDao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(People record){
		record.setPeopleAppId(1);
		return userDao.updateByPrimaryKey(record);
	}


	@Override
	public Result<?> reg(People userDo) {
		
		logger.info("regUser:", userDo);
		userDo.setPeopleState(0);
		userDo.setPeopleAppId(1);
		userDo.setPeopleDatetime(new Date());
		
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


	@Override
	public PageDo<People> getPeoplePage(Map<String, Object> param,
			PageDo<People> page) {
		param.put(Constants.MYBATIS_PAGE, page);
        List<People> list =  userDao.getPeoplePage(param);
        page.setModelList(list);
        return page;
        
	}

    
}
