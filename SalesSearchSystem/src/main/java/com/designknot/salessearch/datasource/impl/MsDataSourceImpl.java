package com.designknot.salessearch.datasource.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.designknot.salessearch.datasource.MsDataSource;
import com.designknot.salessearch.entity.ArealistMst;
import com.designknot.salessearch.entity.MsMst;
import com.designknot.salessearch.repository.ArealistRepository;
import com.designknot.salessearch.repository.MsRepository;

@Component
public class MsDataSourceImpl implements MsDataSource {
	
	@Autowired
	private ArealistRepository repo;
	@Autowired
	private MsRepository msrepo;
	
	@Override
	public List<MsMst> findms(String uriage_date,String pref_cd) {
		List<MsMst> msmst = msrepo.findms(uriage_date, pref_cd);
		return msmst;
	}
	
	@Override
	public List<ArealistMst> searchUriageDate() {
		 List<ArealistMst> date = repo.searchUriageDate();
		 return date;
	}
	
	@Override
	public List<MsMst> searchCategory() {
		 List<MsMst> category = msrepo.searchCategory();
		 return category;
	}
	
	@Override
	public List<MsMst> searchItem() {
		 List<MsMst> item = msrepo.searchItem();
		 return item;
	}
	
	@Override
	public List<MsMst> findall(String uriage_date,String pref_cd, String category_name, String item_name) {
		List<MsMst> all = msrepo.findall(uriage_date, pref_cd, category_name, item_name);
		return all;
	}

}
