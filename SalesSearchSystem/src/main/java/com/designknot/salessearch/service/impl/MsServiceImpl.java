package com.designknot.salessearch.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designknot.salessearch.datasource.ArealistDataSource;
import com.designknot.salessearch.datasource.MsDataSource;
import com.designknot.salessearch.entity.ArealistMst;
import com.designknot.salessearch.entity.MsMst;
import com.designknot.salessearch.services.MsService;

@Service("MsService")
public class MsServiceImpl implements MsService{
	
	@Autowired
	private ArealistDataSource areadata;
	
	@Autowired
	private MsDataSource msdata;
	
	@Override
	public List<MsMst> findms(String uriage_date,String pref_cd) {
		List<MsMst> prefMsts = msdata.findms(uriage_date, pref_cd);
		return prefMsts;
	}

	@Override
	public List<ArealistMst> searchUriageDate() {
		 List<ArealistMst> date = areadata.searchUriageDate();
		 return date;
	}
	
	@Override
	public List<MsMst> searchCategory() {
		 List<MsMst> category = msdata.searchCategory();
		 return category;
	}
	
	@Override
	public List<MsMst> searchItem() {
		 List<MsMst> item = msdata.searchItem();
		 return item;
	}
	
	@Override
	public List<MsMst> findall(String uriage_date,String pref_cd, String category_name, String item_name) {
		List<MsMst> prefMsts = msdata.findall(uriage_date, pref_cd, category_name, item_name);
		return prefMsts;
	}
}
