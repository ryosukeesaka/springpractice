package com.designknot.salessearch.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.designknot.salessearch.entity.UserMst;
import com.designknot.salessearch.repository.UserMstRepository;
@Service
public class UserSecurityService implements UserDetailsService {
	@Autowired
	private UserMstRepository userMstRepository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserMst user = userMstRepository.findByUserid(username);

		if(user == null) {
			throw new UsernameNotFoundException(username + "は見つかりません");
		}
		return new SalesSearchUserDetails(user);
	}



}
