package com.designknot.salessearch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.designknot.salessearch.entity.ArealistMst;
import com.designknot.salessearch.entity.PreflistMst;
import com.designknot.salessearch.form.PreflistForm;
import com.designknot.salessearch.service.impl.PreflistServiceimpl;

@Controller
public class PrefController {
	
	@Autowired
	private PreflistServiceimpl service;
	
	@RequestMapping(value="/user/preflist",params="search",method=RequestMethod.POST)
	public ModelAndView list(
			ModelAndView mav, 
			@ModelAttribute PreflistForm form )
			//@ModelAttribute ("area") String area,
			//@PathVariable String area) 
	{
		//売上年月一覧（プルダウン）
		List<ArealistMst> uriagedate = new ArrayList<ArealistMst>();
		String data = form.getUriage_date();//formに選択値を固定
		uriagedate = service.searchUriageDate();
		mav.setViewName("search/preflist");
		mav.addObject("data", data);
		mav.addObject("date", uriagedate);

		//都道府県一覧
		List<PreflistMst> preflist = new ArrayList<PreflistMst>();
		String a = form.getUriage_date();
		String removed = a.replace("/", "");
		String area = form.getArea_cd();
		String areaname = form.getArea_name();
		//String area = preflist.get(0).getArea_cd();
		
		preflist = service.findpref(area, removed);
		
		mav.setViewName("search/preflist");
		mav.addObject("preflist", preflist);
		mav.addObject("arecd", area);
		mav.addObject("areaname", areaname);
		
		return mav;
		
	}
	
	@RequestMapping(value="/user/preflist/{area}", method=RequestMethod.GET)
	@Transactional(readOnly = false)
	public ModelAndView upd(
			ModelAndView mav,
			@ModelAttribute PreflistForm form,
			//@ModelAttribute ArealistForm areaform,
			//@ModelAttribute ("area") String areax
			@PathVariable String area
			) {

		//売上年月一覧
		List<ArealistMst> uriagedate = new ArrayList<ArealistMst>();
		String data = form.getUriage_date();
		uriagedate = service.searchUriageDate();
		mav.setViewName("search/preflist");
		mav.addObject("date", uriagedate);
		mav.addObject("data", data);
		//String area = form.getArea_cd();
		//都道府県一覧
		List<PreflistMst> preflist = new ArrayList<PreflistMst>();
		preflist = service.findpref(area, uriagedate.get(0).getUriage_date().replace("/",""));
		String arecd = preflist.get(0).getArea_cd();//hiddenに入れてformとやりとり　get(0) index0番目　ex area_cd=04(滋賀、大阪・・・）０５などは入ってこない
		String areaname = preflist.get(0).getArea_name();
		
		mav.setViewName("search/preflist");
		mav.addObject("preflist", preflist);
		mav.addObject("arecd", arecd);
		mav.addObject("areaname", areaname);

		return mav;
	}
	
//	@RequestMapping(value="/user/preflist/{area}", method=RequestMethod.POST)
//	@Transactional(readOnly = false)
//	public ModelAndView post(
//			ModelAndView mav,
//			@ModelAttribute ArealistForm form,
//			@PathVariable String area,
//			RedirectAttributes redirectAttributes
//			) {
//
//		//売上年月一覧
//		List<ArealistMst> uriagedate = new ArrayList<ArealistMst>();
//		uriagedate = service.searchUriageDate();
//		mav.setViewName("search/preflist");
//		mav.addObject("date", uriagedate);
//
//		//エリア一覧
//		List<PreflistMst> preflist = new ArrayList<PreflistMst>();
//		preflist = service.findpref(area, uriagedate.get(0).getUriage_date().replace("/",""));//String area repoから送られてくる
//		mav.setViewName("search/preflist");
//		mav.addObject("preflist", preflist);
//		String msg = "aaaaaaaaaa";
//		mav.addObject("msg", msg);
//		//redirectAttributes.addFlashAttribute("area", area);
//		//return new ModelAndView("redirect:/user/preflist/"+area);
//		return mav;
//	}

}
