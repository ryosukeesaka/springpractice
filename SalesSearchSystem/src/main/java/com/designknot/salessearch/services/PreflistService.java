package com.designknot.salessearch.services;

import java.util.List;

import com.designknot.salessearch.entity.ArealistMst;
import com.designknot.salessearch.entity.PreflistMst;

public interface PreflistService {
	
	public List<PreflistMst> findpref(String pref, String month);

	public List<ArealistMst> searchUriageDate();

}
