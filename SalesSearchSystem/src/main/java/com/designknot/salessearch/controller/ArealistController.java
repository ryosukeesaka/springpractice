package com.designknot.salessearch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.designknot.salessearch.entity.ArealistMst;
import com.designknot.salessearch.form.ArealistForm;
import com.designknot.salessearch.service.impl.ArealistServiceImpl;

@Controller
public class ArealistController {

	@Autowired
	private ArealistServiceImpl service;

	@RequestMapping(value="/user/arealist",params="reg",method=RequestMethod.POST)
	public ModelAndView list(ModelAndView mav, @ModelAttribute ArealistForm form) {
		//売上年月一覧
		List<ArealistMst> uriagedate = new ArrayList<ArealistMst>();
		String data = form.getUriage_date();//formに選択値を固定
		uriagedate = service.searchUriageDate();
		mav.setViewName("search/arealist");
		mav.addObject("data", data);
		mav.addObject("date", uriagedate);

		//エリア一覧
		List<ArealistMst> arealist = new ArrayList<ArealistMst>();
		String a = form.getUriage_date();
		String removed = a.replace("/", "");
		arealist = service.findAll(removed);
		mav.setViewName("search/arealist");
		mav.addObject("arealist", arealist);

		return mav;

	}

	@RequestMapping(value="/user/arealist", method=RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView post(
			ModelAndView mav,
			@ModelAttribute ArealistForm form
			) {

		//売上年月一覧
		List<ArealistMst> uriagedate = new ArrayList<ArealistMst>();
		uriagedate = service.searchUriageDate();
		mav.setViewName("search/arealist");
		mav.addObject("date", uriagedate);

		//エリア一覧
		List<ArealistMst> arealist = new ArrayList<ArealistMst>();
		arealist = service.findAll(uriagedate.get(0).getUriage_date().replace("/",""));
		mav.setViewName("search/arealist");
		mav.addObject("arealist", arealist);

		return mav;

	}

	@RequestMapping(value="/user/arealist", method=RequestMethod.GET)
	@Transactional(readOnly = false)
	public ModelAndView upd(
			ModelAndView mav,
			@ModelAttribute ArealistForm form
			) {

		//売上年月一覧
		List<ArealistMst> uriagedate = new ArrayList<ArealistMst>();
		String data = form.getUriage_date();
		uriagedate = service.searchUriageDate();
		mav.setViewName("search/arealist");
		mav.addObject("date", uriagedate);
		mav.addObject("data", data);

		//エリア一覧
		List<ArealistMst> arealist = new ArrayList<ArealistMst>();
		arealist = service.findAll(uriagedate.get(0).getUriage_date().replace("/",""));
		mav.setViewName("search/arealist");
		mav.addObject("arealist", arealist);

		return mav;
	}
}
