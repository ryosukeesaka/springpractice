package com.designknot.salessearch.datasource;

import java.util.List;

import com.designknot.salessearch.entity.ArealistMst;
import com.designknot.salessearch.entity.PreflistMst;

public interface PreflistDataSource {
	
	List<PreflistMst> findpref(String pref, String month);
	
	List<ArealistMst> searchUriageDate();

}
