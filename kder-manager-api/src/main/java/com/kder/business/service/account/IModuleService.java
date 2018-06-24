/**
 * @fileName XXXX.java
 * @auther yepeng
 * @version 1.0
 * @date   2017-08-23 17:57:23
 */


package com.kder.business.service.account;

/**
 * @author yepeng
 * @TODO
 */


import java.util.List;
import java.util.Map;

import com.kder.business.common.page.PageDo;
import com.kder.business.entity.account.ModuleDo;
import com.kder.business.entity.account.ResourcesDo;

public interface IModuleService {

	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	public ModuleDo getById(Long id);
	
	/**
	 *根据条件查询列表
	 */
	public List<ModuleDo> selectModule(Map<String, Object> parameterMap);

	/**
	 * 更新
	 */
	public int updateModuleById(ModuleDo newModuleDo);

	/**
	 * 新增
	 */
	public int addModule(ModuleDo newModuleDo);

	/**
	 * 删除
	 */
	public int deleteById(Long id);
	/**
	 * @author tangkmf
	 * 获取用户有权限的模块
	 * @param userId
	 * @return
	 * @time 2017年8月30日16:20:04 迁移
	 */
	public List<ModuleDo> getUserModules(int userId);

	public PageDo<ResourcesDo> getResources(PageDo<ResourcesDo> page, String name);
	public PageDo<ResourcesDo> getResourcesInModule(
            PageDo<ResourcesDo> page, String resourceName);

	public int deleteOneResource(Integer parseInt);

	public int saveResources(ResourcesDo r);

	public ResourcesDo getOneResource(int id);
	/**
	 * 从modelMap中获取所有的models
	 * @return
	 */
	public List<ModuleDo> getAllModules();

	public  PageDo<ModuleDo> getAllModules(PageDo<ModuleDo> modules, String moduleName, String moduleNick);

	public int saveModule(ModuleDo module);

	public ModuleDo getModuleById(long l);

	public int deleteModuleById(Integer moduleId);

	//public ModuleDo getModuleById(int id);
}
