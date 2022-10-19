package com.designknot.salessearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.designknot.salessearch.repository.UserMstRepository;

@Controller
public class UserController {

	@Autowired
	public UserMstRepository userMstRepository;

	/*@RequestMapping("/user/arealist")
	public ModelAndView user(ModelAndView mav) {
		mav.setViewName("search/area");
		return mav;
	}*/
}