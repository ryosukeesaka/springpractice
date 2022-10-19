package com.designknot.salessearch.datasource;

import java.util.List;

import com.designknot.salessearch.entity.ArealistMst;
import com.designknot.salessearch.entity.MsMst;

public interface MsDataSource {
	
	List<MsMst> findms (String uriage_date, String pref_cd);
	
	List<ArealistMst> searchUriageDate();
	
	List<MsMst> searchCategory();
	
	List<MsMst> searchItem();
	
	List<MsMst> findall(String uriage_date, String pref_cd, String category_name, String item_name);

}
