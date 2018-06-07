package com.kder.business.service.user;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.kder.business.common.result.Result;
import com.kder.business.common.util.DataEncrypt;
import com.kder.business.dao.user.IUserDao;
import com.kder.business.entity.user.UserDo;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Resource
    private IUserDao userDao;
   

    @Override
    public UserDo getUser(String userName) {
        Map<String, Object> params = new HashMap<>();
        params.put("userName", userName);
        List<UserDo> list = userDao.selectUser(params);

        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.get(0);
    }

    @Override
    public UserDo getUser(Integer userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Result<?> reg(UserDo userDo) {
    	userDo.setUserName(userDo.getUserName().trim());
    	userDo.setRefereeUserName(userDo.getRefereeUserName().trim());
    	
        UserDo oldUser = getUser(userDo.getUserName());
        if (oldUser != null) {
            return Result.failureResult("用户已存在");
        }

        UserDo ref = getUser(userDo.getRefereeUserName());
        if(ref == null){
            return Result.failureResult("推荐人不存在");
        }
        
        
        String twoPassword = userDo.getTwoPassword(); //加密前交易密码，用来以太坊开户
        userDo.setRefereeid(ref.getId());
        userDo.setRegTime(new Date().getTime());
        userDo.setUserPassword(DataEncrypt.encrypt(userDo.getUserPassword())); //密码加密处理
        userDo.setTwoPassword(DataEncrypt.encrypt(userDo.getTwoPassword()));
        
        //用户注册
        int result = userDao.insertSelective(userDo);

        return result > 0?Result.successResult("注册成功!"):Result.failureResult("注册失败");
    }

	@Override
	public List<UserDo> selectUser(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<?> update(UserDo userDo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDo> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
