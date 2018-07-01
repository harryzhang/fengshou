package com.kder.business.service.security;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kder.business.common.constant.Constants;
import com.kder.business.common.page.PageDo;
import com.kder.business.dao.security.IAuthoritiesDao;
import com.kder.business.dao.security.IRolesDao;
import com.kder.business.dao.security.IRolesauthorityDao;
import com.kder.business.dao.security.IUsersDao;
import com.kder.business.dao.security.IUsersrolesDao;
import com.kder.business.dao.security.IWhiteListDao;
import com.kder.business.entity.account.ManagersDo;
import com.kder.business.entity.account.RolesDo;
import com.kder.business.entity.account.RolesauthorityDo;
import com.kder.business.entity.account.UsersrolesDo;
import com.kder.business.service.account.IManagerUserService;

@Service("managerUserService")
public class ManagerUserServiceImpl implements IManagerUserService {

    @Resource
	protected IUsersDao userDao;
    @Resource
	protected IAuthoritiesDao authoritiesDao;
    @Resource
	protected IRolesDao rolesDao;
    @Resource
	protected IUsersrolesDao usersRolesDao;
    @Resource
	protected IRolesauthorityDao rolesAuthorityDao;
    @Resource
	private IWhiteListDao whiteListDao;

	
	
	

	/**
	 * 新增用户
	 */
	@Override
	public int addUsers(ManagersDo user) {
		
		user.setEnabled(true);
		int ret = -1;
		if (user.getId() != null) {
			ret = userDao.updateUser(user);
		} else {
			ret = userDao.addUser(user);
			//添加用户部门关系
			if(user.getDeptId() != null){
				userDao.addDeptUser(user);
			}
			
		}
		
		return ret == 1 ? Constants.SUCCESS : Constants.FAIL;
	}

	public ManagersDo getUserById(int userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public ManagersDo getUser(String username) {
		ManagersDo user = userDao.getUserDetailsByUserName(username);
		// 支持手机号码登录
		if (user == null || user.getId() == null) {
			user = userDao.getUserDetailsByMobile(username);
		}
		if(user == null){
			return new ManagersDo();
		}
		return user;
	}

	@Override
	public boolean isWhiteList(String username) {

		try {
			List<Map<String, Object>> datas = whiteListDao.getWhiteList(username);
			if (datas != null && datas.size() > 0) { // 存在白名单中
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 删除用户
	 */
	@Override
	public int deleteOneUser(int userId) {
		int ret = userDao.deleteUser(userId);
		return ret == 1 ? Constants.SUCCESS : Constants.FAIL;
	}

	@Override
	public PageDo<ManagersDo> getManagersByPage(PageDo<ManagersDo> page, String username) {
		return this.getDeptManagersByPage(page, username, null,null);
	}

	
	@Override
	public PageDo<ManagersDo> getManagersByPage(PageDo<ManagersDo> page,String username, String nickName) {
		return this.getDeptManagersByPage(page, username, nickName,null);
	}
	
	/**
	 * 
	 * 部门管理员查看部门用户
	 * zhangyunhmf
	 *
	 * @see com.hehenian.service.manager.IManagerUserService#getDeptManagersByPage(com.hehenian.common.page.PageDo, String, String, Integer)
	 *
	 */
    @Override
    public PageDo<ManagersDo> getDeptManagersByPage(PageDo<ManagersDo> page, String userName, String nickName, Integer deptId) {
    	Map<String, Object> params = new HashMap<>();
		params.put(Constants.MYBATIS_PAGE, page);
		List<ManagersDo> datas = Collections.emptyList();

		if( StringUtils.isNotBlank(userName) ){
			params.put("userName", userName);
		}
		if( StringUtils.isNotBlank(nickName) ){
			params.put("nickName", nickName);
		}
		if(deptId != null ){
			params.put("deptId", deptId);
			datas = userDao.getDeptUsersByPage(params);
		}else{
			datas = userDao.getUsersByPage(params);
		}
		page.setDatas(datas);
		return page;
    }


	@Override
	public PageDo<RolesDo> getRolesByPage(PageDo<RolesDo> page, String roleName) {

		Map<String, Object> params = new HashMap<>();
		params.put(Constants.MYBATIS_PAGE, page);
		params.put("roleName", roleName);

		List<RolesDo> datas = rolesDao.getRolesByPage(params);
		page.setDatas(datas);
		return page;
	}

	/**
	 *
	 * zhangyunhmf
	 *
	 * @see com.hehenian.service.manager.IManagerUserService#getDeptRolesByPage(com.hehenian.common.page.PageDo, String, Integer)
	 *
	 */
    @Override
    public PageDo<RolesDo> getDeptRolesByPage(PageDo<RolesDo> page, String roleName, Integer deptId) {

    	Map<String, Object> params = new HashMap<>();

    	params.put(Constants.MYBATIS_PAGE, page);
		if(StringUtils.isNotBlank(roleName)){
			params.put("roleName", roleName);
		}
		params.put("deptId", deptId);
		List<RolesDo> datas = rolesDao.getDeptRolesByPage(params);
		page.setDatas(datas);
		return page;
    }


	@Override
	public RolesDo getOneRoleById(int roleId) {
		return rolesDao.getOneRoleById(roleId);
	}

	@Override
	public int deleteOneRole(int roleId) {
		int ret = rolesDao.deleteRole(roleId);
		return ret == 1 ? Constants.SUCCESS : Constants.FAIL;
	}

	@Override
	public int updateOneRole(RolesDo role) {
		int ret = Constants.FAIL;
		role.setEnabled(true);
		if (role.getId() != null) {
			// ret = rolesDao.updateRole(role);
			ret = rolesDao.updateRolesById(role);
		} else {
			// ret = rolesDao.addRole(role);
			ret = rolesDao.addRoles(role);
		}
		return ret == 1 ? Constants.SUCCESS : Constants.FAIL;
	}

	@Override
	public PageDo<ManagersDo> getManagersInOrNotInRolesByPage(PageDo<ManagersDo> page, int roleId, boolean flag) {

		return this.getManagersInOrNotInRolesByPage(page, roleId, flag, null, null);
	}

	@Override
	public PageDo<ManagersDo> getManagersInOrNotInRolesByPage(PageDo<ManagersDo> page, int roleId, boolean flag, String userName,String nickName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Constants.MYBATIS_PAGE, page);
		params.put("roleId", roleId);
		if(StringUtils.isNotBlank(userName)){
			params.put("username", userName);
		}
		if(StringUtils.isNotBlank(nickName)){
			params.put("nickname", nickName);
		}

		List<ManagersDo> modelList = flag ? userDao.getUsersInRolesByPage(params) :
			userDao.getUsersNotInRolesByPage(params);
		page.setDatas(modelList);
		return page;
	}

	@Override
	public int addUsersRoles(UsersrolesDo ur) {
		if (usersRolesDao.countUsersroles(ur) > 0) {
			return Constants.FAIL;
		}
		int ret = usersRolesDao.addUsersroles(ur);
		return ret == 1 ? Constants.SUCCESS : Constants.FAIL;
	}

	@Override
	public int deleteUsersRoles(UsersrolesDo ur) {
		int ret = usersRolesDao.deleteUserRoles(ur);
		return ret > 0 ? Constants.SUCCESS : Constants.FAIL;
	}

	@Override
	public PageDo<RolesDo> getRolesInOrNotInAuthoritiesByPage(PageDo<RolesDo> page,
			int authId, boolean inOrNot) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(Constants.MYBATIS_PAGE, page);
		params.put("authId", authId);
		List<RolesDo> modelList = inOrNot ? rolesDao.getRolesInAuthorityByPage(params) : rolesDao
				.getRolesNotInAuthorityByPage(params);
		page.setDatas(modelList);
		return page;
	}

	@Override
	public PageDo<RolesDo> getRolesInOrNotInAuthoritiesByPage(PageDo<RolesDo> page, int authId, boolean inOrNot,String roleName, String roleDesc) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put(Constants.MYBATIS_PAGE, page);
		params.put("authId", authId);
		params.put("roleName", roleName);
		params.put("roleDesc", roleDesc);
		List<RolesDo> modelList = inOrNot ? rolesDao.getRolesInAuthorityByPage(params) : rolesDao.getRolesNotInAuthorityByPage(params);
		page.setDatas(modelList);
		return page;
	}

	@Override
	public List<RolesDo> getUserAllRoles(int userId) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userId", userId);
		//原来是getRolesByPage，因为这里不需要分页，所以用selectRoles；如果后面要用分页再改
		return rolesDao.getRolesByUserId(params);
	}

	@Override
	public int addRolesAuthority(RolesauthorityDo ra) {
		int ret = rolesAuthorityDao.addRolesauthority(ra);
		return ret == 1 ? Constants.SUCCESS : Constants.FAIL;
	}

	 @Override
	 public int deleteRolesAuthority(RolesauthorityDo ra) {
	 int ret = rolesAuthorityDao.deleteRolesauthority(ra);
	 return ret > 0 ? Constants.SUCCESS : Constants.FAIL;
	 }

	@Override
	public int resetCurrentUserPwd(int userId, String oldPassword,
			String newPassword) {
		if (StringUtils.isBlank(oldPassword)
				|| StringUtils.isBlank(newPassword)) {
			return Constants.FAIL;
		}
		ManagersDo user = userDao.getUserById(userId);
		if (user == null) {
			return Constants.FAIL;
		}

		user.setPassword(newPassword);
		user.setPasswordUpdateTime(new Date());
		int count = userDao.updateUser(user);
		return count > 0 ? Constants.SUCCESS : Constants.FAIL;
		
	}

	@Override
	public int resetUserPwd(int userId, String newPassword) {
		ManagersDo user = userDao.getUserById(userId);
		if (user == null) {
			return Constants.FAIL;
		}
		user.setPassword(newPassword);
		user.setPasswordUpdateTime(new Date());
		int count = userDao.updateUser(user);
		return count > 0 ? Constants.SUCCESS : Constants.FAIL;
	}

	@Override
	public List<ManagersDo> getCouldFollowOrderPersons(String roleDesc) {
		return userDao.getCouldFollowOrderPersons(roleDesc);
	}


	/**
	 *
	 * zhangyunhmf
	 *
	 * @see com.hehenian.service.manager.IManagerUserService#getDeptManagersInOrNotInRolesByPage(com.hehenian.common.page.PageDo, int, boolean, String, String, Integer)
	 *
	 */
    @Override
    public PageDo<ManagersDo> getDeptManagersInOrNotInRolesByPage(PageDo<ManagersDo> page,int roleId, boolean flag, String userName, String nickName, Integer deptId) {
    	Map<String, Object> params = new HashMap<String, Object>();
		params.put(Constants.MYBATIS_PAGE, page);
		params.put("roleId", roleId);
		params.put("deptId", deptId);
		
		if(StringUtils.isNotBlank(userName)){
			params.put("username", userName);
		}
		if(StringUtils.isNotBlank(nickName)){
			params.put("nickname", nickName);
		}
		
		List<ManagersDo> modelList = flag ? userDao.getDeptUsersInRolesByPage(params) :
			userDao.getDeptUsersNotInRolesByPage(params);
		page.setDatas(modelList);
		return page;
    }

	
}
