package com.kder.business.dao.security;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface IWhiteListDao {
	
	//返回白名单，根据返回的list是否为null或空判断是否白名单，否则是
	List<Map<String,Object>> getWhiteList(String username);
	
}
