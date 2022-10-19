package com.designknot.salessearch.services;

import java.util.List;

import com.designknot.salessearch.entity.ArealistMst;
import com.designknot.salessearch.entity.MsMst;

public interface MsService {
	
	public List<MsMst> findms(String uriage_date,String pref_cd);

	public List<ArealistMst> searchUriageDate();
	
	public List<MsMst> searchCategory();
	
	public List<MsMst> searchItem();
	
	public List<MsMst> findall(String uriage_date,String pref_cd, String category_name, String item_name);

}
