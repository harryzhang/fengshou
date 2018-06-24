package com.kder.business.provider;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kder.business.entity.account.AuthoritiesDo;
import com.kder.business.entity.account.ManagersDo;
import com.kder.business.entity.secrety.AuthDo;
import com.kder.business.entity.secrety.UserInfos;
import com.kder.business.service.account.IAuthoritiesService;
import com.kder.business.service.account.IManagerUserService;

public class UserDetailsServiceImpl implements UserDetailsService{
	
    @Resource
    private IManagerUserService managerUserService;
    
    @Resource
    private IAuthoritiesService authoritiesService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        ManagersDo data = managerUserService.getUser(userName);

        List<AuthoritiesDo> authorities = authoritiesService.getGrantedAuthority(data.getId());
        List<GrantedAuthority> results = new ArrayList<GrantedAuthority>();
        for (AuthoritiesDo data1 : authorities) {
            GrantedAuthority ga = new AuthDo(data1);
            results.add(ga);
        }
        UserInfos details = new UserInfos(data.getId(), data.getUsername(), data.getNickname(), data.getPassword(), data.getSalt(),data.getDeptId(), true, true, true,
                true, results);
        return details;
    }
}
