package com.designknot.salessearch.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designknot.salessearch.datasource.ArealistDataSource;
import com.designknot.salessearch.datasource.PreflistDataSource;
import com.designknot.salessearch.entity.ArealistMst;
import com.designknot.salessearch.entity.PreflistMst;
import com.designknot.salessearch.services.PreflistService;

@Service("PreflistService")
public class PreflistServiceimpl  implements PreflistService{
	
	@Autowired
	private ArealistDataSource src;
	
	@Autowired
	private PreflistDataSource prefdata;

	@Override
	public List<PreflistMst> findpref(String pref, String month) {
		List<PreflistMst> prefMsts = prefdata.findpref(pref, month);
		return prefMsts;
	}

	@Override
	public List<ArealistMst> searchUriageDate() {
		 List<ArealistMst> date = src.searchUriageDate();
		 return date;
	}

}
