package com.kder.business.entity.secrety;

import org.springframework.security.core.GrantedAuthority;

import com.kder.business.entity.account.AuthoritiesDo;

public class AuthDo implements GrantedAuthority,java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4672600493493411381L;
	
	
	private AuthoritiesDo authorities;

	@Override
	public String getAuthority() {
		return authorities.getName();
	}
	
	public AuthDo(AuthoritiesDo authorities){
		this.authorities = authorities;
	}

}
