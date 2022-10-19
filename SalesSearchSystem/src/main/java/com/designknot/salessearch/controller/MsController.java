    package com.designknot.salessearch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.designknot.salessearch.entity.ArealistMst;
import com.designknot.salessearch.entity.MsMst;
import com.designknot.salessearch.form.MsForm;
import com.designknot.salessearch.service.impl.MsServiceImpl;

@Controller
public class MsController {

	@Autowired
	private MsServiceImpl service;

	//エリア別から遷移してくる
	@RequestMapping(value="/user/mslist/{pref_cd}", method=RequestMethod.GET)
	@Transactional(readOnly = false)
	public ModelAndView index(
			@ModelAttribute MsForm form,
			ModelAndView mav,
			@PathVariable String pref_cd)
	{

		//商品カテゴリー
		List<MsMst> category = new ArrayList<MsMst>();
		category = service.searchCategory();
		mav.setViewName("search/mslist");
		mav.addObject("category", category);

		//商品名
		List<MsMst> item = new ArrayList<MsMst>();
		item = service.searchItem();
		mav.setViewName("search/mslist");
		mav.addObject("item", item);

		//売上日一覧
		List<ArealistMst> uriagedate = new ArrayList<ArealistMst>();
		String data = form.getUriage_date();
		uriagedate = service.searchUriageDate();
		mav.setViewName("search/mslist");
		mav.addObject("date", uriagedate);
		mav.addObject("data", data);

		//店一覧
		List<MsMst> mslist = new ArrayList<MsMst>();
		mslist = service.findms(pref_cd, uriagedate.get(0).getUriage_date().replace("/",""));
		String areacd = mslist.get(0).getArea_cd();
		String prefcd = mslist.get(0).getPref_cd();
		String prefname = mslist.get(0).getPref_name();
		String areaname = mslist.get(0).getArea_name();
		mav.setViewName("search/mslist");
		mav.addObject("mslist", mslist);
		mav.addObject("prefname", prefname);
		mav.addObject("prefcd", prefcd);
		mav.addObject("areaname", areaname);
		mav.addObject("areacd", areacd);


		return mav;
	}

	@RequestMapping(value="/user/mslist", params="search",method=RequestMethod.POST)
	public ModelAndView post(
			@ModelAttribute  @Validated MsForm form,
			ModelAndView mav
			)
	{

		//商品カテゴリー
		List<MsMst> category = new ArrayList<MsMst>();
		category = service.searchCategory();
		mav.setViewName("search/mslist");
		mav.addObject("category", category);

		//商品名
		List<MsMst> item = new ArrayList<MsMst>();
		item = service.searchItem();
		mav.setViewName("search/mslist");
		mav.addObject("item", item);

		//売上日一覧
		List<ArealistMst> uriagedate = new ArrayList<ArealistMst>();
		String data = form.getUriage_date();
		uriagedate = service.searchUriageDate();
		mav.setViewName("search/mslist");
		mav.addObject("date", uriagedate);
		mav.addObject("data", data);

		//商品名、カテゴリー、売上で検索
		List<MsMst> mslist = new ArrayList<MsMst>();
		List<MsMst> datelist  = new ArrayList<MsMst>();
		String a = form.getUriage_date();
		String removed = a.replace("/", "");
		String prefcd = form.getPref_cd();//hiddenで値を保管
		String prefname = form.getPref_name();
		String areaname = form.getArea_name();
		String itemname = form.getItem_name();
		String categ = form.getCategory_name();
		String areacd = form.getArea_cd();
		mslist = service.findall(prefcd, removed,categ,itemname);
		datelist = service.findms(prefcd, uriagedate.get(0).getUriage_date().replace("/",""));
		//該当条件が無かった場合
		if (mslist.isEmpty()){
			mav.setViewName("search/mslist");
			String msg = "該当する条件はありません";
			mav.addObject("msgbox", msg);
		}

		mav.setViewName("search/mslist");
		mav.addObject("mslist", mslist);
		//mav.addObject("datelist", datelist);
		mav.addObject("prefcd", prefcd);
		mav.addObject("prefname", prefname);
		mav.addObject("areaname", areaname);
		mav.addObject("areacd", areacd);


		return mav;
	}

	//年月日のみで検索
	/*@RequestMapping(value="/user/mslist",params="date",method=RequestMethod.POST)
	public ModelAndView index(
			@ModelAttribute  MsForm form,
			ModelAndView mav
			)
	{
		//売上日一覧
		List<ArealistMst> uriagedate = new ArrayList<ArealistMst>();
		String data = form.getUriage_date();
		uriagedate = service.searchUriageDate();
		mav.setViewName("search/index");
		mav.addObject("date", uriagedate);
		mav.addObject("data", data);

		//商品名、カテゴリー、売上で検索
		List<MsMst> mslist = new ArrayList<MsMst>();
		String a = form.getUriage_date();
		String removed = a.replace("/", "");
		String prefcd = form.getPref_cd();//hiddenで値を保管
		String prefname = form.getPref_name();
		String areaname = form.getArea_name();
		String itemname = form.getItem_name();
		String categ = form.getCategory_name();
		mslist = service.findms(prefcd, removed);
		//該当条件が無かった場合
		if (mslist.isEmpty()){
			mav.setViewName("search/index");
			String msg = "該当する条件はありません";
			mav.addObject("msgbox", msg);
		}
		mav.setViewName("search/index");
		mav.addObject("mslist", mslist);
		mav.addObject("prefcd", prefcd);
		mav.addObject("prefname", prefname);
		mav.addObject("areaname", areaname);

		return mav;
	}*/


}
