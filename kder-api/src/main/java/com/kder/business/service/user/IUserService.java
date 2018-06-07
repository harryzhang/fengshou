package com.kder.business.service.user;

import java.util.List;
import java.util.Map;

import com.kder.business.common.result.Result;
import com.kder.business.entity.user.UserDo;

public interface IUserService {

    /** 
     * 根据用户名查用户
     * @param userName
     * @return  
     */
    UserDo getUser(String userName);

    /**
     * 查询用户 
     * @param userId
     * @return  
     */
    UserDo getUser(Integer userId);

    /**
     * 用户注册 
     * @param userDo
     * @return  
     */
    Result<?> reg(UserDo userDo);

   

    List<UserDo> selectUser(Map<String, Object> params);

    Result<?> update(UserDo userDo);

	/** 
     * 查询分页
     * @param params
     * @return  
     */
    List<UserDo> selectPage(Map<String, Object> params);
  
    
}
