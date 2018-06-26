package com.kder.business.dao.choose;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface ICommonChooseDao {

	/**
	 * 分页查询
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> getChooseProductPage(Map<String, Object> param);
	/**
	 * 分页查询
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> getChooseManagerPeoplePage(Map<String, Object> param);
	/**
	 * 分页查询
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> getChoosePeoplePage(Map<String, Object> param);

}
