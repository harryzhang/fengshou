/**
 * @fileName XXXX.java
 * @auther yepeng
 * @version 1.0
 * @date   2017-08-23 17:58:03
 */

 
package com.kder.business.service.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kder.business.common.constant.Constants;
import com.kder.business.common.page.PageDo;
import com.kder.business.dao.security.IAuthoritiesDao;
import com.kder.business.dao.security.IAuthorityresourcesDao;
import com.kder.business.dao.security.IResourcesDao;
import com.kder.business.dao.security.IRolesauthorityDao;
import com.kder.business.entity.account.AuthoritiesDo;
import com.kder.business.entity.account.AuthorityresourcesDo;
import com.kder.business.entity.account.ResourcesDo;
import com.kder.business.service.account.IAuthoritiesService;

/**
 * @author tangkmf
 * @TODO
 */


@Service("authoritiesService")
public class AuthoritiesServiceImpl implements IAuthoritiesService {

	private final Logger logger = Logger.getLogger(this.getClass());

	@Resource
    private IAuthoritiesDao authoritiesDao;
    @Resource
    private IAuthorityresourcesDao authorityResourcesDao;
    @Resource
    private IRolesauthorityDao rolesAuthorityDao;
    @Resource
    private IResourcesDao resourcesDao;
	private static Map<String, List<String>> resourceMap;
	/**
	 * 根据ID 查询
	 * @parameter id
	 */
	@Override
	public AuthoritiesDo getById(Long id){
	  return authoritiesDao.getById(id);
	}
	
	/**
	 *根据条件查询列表
	 */
	@Override
	public List<AuthoritiesDo> selectAuthorities(Map<String,Object> parameterMap){
		return authoritiesDao.selectAuthorities(parameterMap);
	}
	
	/**
	 * 更新
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int updateAuthoritiesById(AuthoritiesDo newAuthoritiesDo){
		logger.debug("updateAuthorities(AuthoritiesDo: "+newAuthoritiesDo);
		return authoritiesDao.updateAuthoritiesById(newAuthoritiesDo);
	}
	
	/**
	 * 新增
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int addAuthorities(AuthoritiesDo newAuthoritiesDo){
		logger.debug("addAuthorities: "+newAuthoritiesDo);
		return authoritiesDao.addAuthorities(newAuthoritiesDo);
	}
	
	/**
	 * 删除
	 */
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int deleteById(Long id){
		logger.debug("deleteByIdAuthorities:"+id);
		return authoritiesDao.deleteById(id);
	}

	@Override
	public PageDo<AuthoritiesDo> getAuthority(PageDo<AuthoritiesDo> page, String name, String authDesc) {
		Map<String,Object> params = new HashMap<>();
		params.put(Constants.MYBATIS_PAGE, page);
		params.put("name", name);
		params.put("authDesc", authDesc);
		if(page.getTotal() == null){
			page.setTotal(1L);
		}
		if(page.getPage() == null){
			page.setPage(1L);
		}
		if(page.getTotalPage() == null){
			page.setTotalPage(1L);
		}
		List<AuthoritiesDo> datas = authoritiesDao.getAuthorityPage(params);
		logger.info(datas);
		page.setDatas(datas);
		return page;
	}

	@Override
	public PageDo<AuthoritiesDo> getInOrNotAuthoritiesByRoleId(PageDo<AuthoritiesDo> pageDo, int roleId, boolean inRoleOrNot) {
		Map<String,Object> map = new HashMap<>();
		map.put("roleId", (Integer)roleId );
		map.put(Constants.MYBATIS_PAGE, pageDo);
		if(inRoleOrNot){
			pageDo.setDatas(rolesAuthorityDao.getAuthoritiesInRolesPage(map));
		}else{
			pageDo.setDatas(rolesAuthorityDao.getAuthoritiesNotInRolesPage(map));
		}
		
		return pageDo;
		//return ?:rolesAuthorityDao.getAuthoritiesNotInRoles(list, roleId);
	}

	@Override
	public Map<String, List<String>> getResourceMap() {
		/*
		 * 应当是资源为key， 权限为value。 资源通常为url， 权限就是那些以ROLE_为前缀的角色。 一个资源可以由多个权限来访问。
		 */
		if(resourceMap == null){
			resourceMap = new HashMap<String, List<String>>();
			Collection<AuthoritiesDo> authList = AuthoritiesDo.load(authorityResourcesDao.getAuthorities());
			for (AuthoritiesDo auth : authList) {
				String ca =auth.getName();
				for (ResourcesDo res : auth.getResources()) {
					String url = res.getResourceStr();
					/*
					 * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，则要通过该url为key提取出权限集合，将权限增加到权限集合中
					 * 。
					 */
					if (resourceMap.containsKey(url)) {

						List<String> value = resourceMap
								.get(url);
						value.add(ca);
						resourceMap.put(url, value);
					} else {
						ArrayList<String> atts = new ArrayList<String>();
						atts.add(ca);
						resourceMap.put(url, atts);
					}
				}
			}
		}
		return resourceMap;
	}

	@Override
	public PageDo<ResourcesDo> getResourcesInOrNotAuthority(PageDo<ResourcesDo> page, int authorityId, boolean b,
			String filterName, String filterLinks) {
		Map<String,Object> params = new HashMap<>();
		params.put(Constants.MYBATIS_PAGE, page);
		params.put("authorityId", authorityId);
		
		if(StringUtils.isNotBlank(filterName)){
			params.put("name", filterName);
		}
		
		if(StringUtils.isNotBlank(filterLinks)){
			params.put("resourceStr", filterLinks);
		}
		
		if(page.getTotal() == null){
			page.setTotal(1L);
		}
		if(page.getPage() == null){
			page.setPage(1L);
		}
		if(page.getTotalPage() == null){
			page.setTotalPage(1L);
		}
		if(b){
			page.setDatas(resourcesDao.getResourcesInInAuthorityPage(params));
		}else{
			page.setDatas(resourcesDao.getResourceNotInAuthorityPage(params));
		}
		return page;
	}

	@Override
	public int addAuthorityResource(AuthorityresourcesDo ar) {
		// int ret=1;
		int ret = 0;
		// 数据库没存在关系才加，已经存在了不加
		if (authorityResourcesDao.checkRelationExist(ar) == 0) {
			ret = authorityResourcesDao.addRelation(ar);
			// 加入权限访问列表中
			ResourcesDo res = resourcesDao.getById(ar.getResourceId() + 0L);
			AuthoritiesDo auth = authoritiesDao.getById(ar.getAuthorityId() + 0L);
			String url = res.getResourceStr();
			/*
			 * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，则要通过该url为key提取出权限集合，将权限增加到权限集合中 。
			 */
			//ConfigAttribute ca = new SecurityConfig(auth.getName());
			String ca = auth.getName();
			if (resourceMap.containsKey(url)) {

				List<String> value = resourceMap.get(url);
				value.add(ca);
				resourceMap.put(url, value);
			} else {
				List<String> atts = new ArrayList<String>();
				atts.add(ca);
				resourceMap.put(url, atts);
			}
		}
		return ret == 1 ? Constants.SUCCESS : Constants.FAIL;
	}

	@Override
	public int deleteAuthorityResource(AuthorityresourcesDo ar) {
		//return authorityResourcesDao.deleteById(Long.valueOf(ar.getAuthorityId())) == 1? Constants.SUCCESS : Constants.FAIL;
		int ret = authorityResourcesDao.deleteRelationById(ar);
		return ret == 1 ? Constants.SUCCESS : Constants.FAIL;
	}

	@Override
	public AuthoritiesDo getAuthorities(int parseInt) {
		
		return authoritiesDao.getById(Long.valueOf(parseInt));
	}

	

	@Override
	public List<Map<String,Object>> getAuthorities() {
		return authorityResourcesDao.getAuthorities();
	}
	
	@Override
	public List<AuthoritiesDo> getGrantedAuthority(long id){
		return authoritiesDao.getGrantedAuthority(id);
	}

	
}
