package com.designknot.salessearch.service.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.designknot.salessearch.entity.UserMst;

public class SalesSearchUserDetails implements UserDetails {

	public UserMst userMst;

	public SalesSearchUserDetails(UserMst userMst) {
		this.userMst = userMst;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String getPassword() {

		return this.userMst.getUser_passwd();
	}

	@Override
	public String getUsername() {
		//もとのメソッド名はユーザー名だが、今回はユーザー名にユーザーIDを使用するため
		return this.userMst.getUser_id();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

}
