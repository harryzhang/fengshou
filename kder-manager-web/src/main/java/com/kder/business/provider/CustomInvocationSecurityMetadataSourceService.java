package com.kder.business.provider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import com.kder.business.service.account.IAuthoritiesService;

/**
 * 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。 此类在初始化时，应该取到所有资源及其对应角色的定义。
 *
 */
public class CustomInvocationSecurityMetadataSourceService implements
		FilterInvocationSecurityMetadataSource {

    @Resource
	protected IAuthoritiesService authorityService;

	private PathMatcher urlMatcher = new AntPathMatcher();

	public CustomInvocationSecurityMetadataSourceService() {
	}



	public Collection<ConfigAttribute> getAllConfigAttributes() {

		return null;
	}

	// 根据URL，找到相关的权限配置。
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {

		// object 是一个URL，被用户请求的url。
		String url = ((FilterInvocation) object).getRequestUrl();

        int firstQuestionMarkIndex = url.indexOf("?");

        if (firstQuestionMarkIndex != -1) {
            url = url.substring(0, firstQuestionMarkIndex);
        }

        Map<String, List<String>> resourceMap=authorityService.getResourceMap();

		Iterator<String> ite = resourceMap.keySet().iterator();

		while (ite.hasNext()) {
			String resURL = ite.next();

			if (urlMatcher.matchStart(url, resURL)) {
				Collection<ConfigAttribute> rst = new ArrayList<ConfigAttribute>();

				for(String forMap:resourceMap.get(resURL)){
					rst.add(new SecurityConfig(forMap));
				}

				return rst;
			}
		}
		return null;
	}

	public boolean supports(Class<?> arg0) {

		return true;
	}


	@Autowired
	public void setAuthorityService(IAuthoritiesService authorityService) {
		this.authorityService = authorityService;
	}
}
