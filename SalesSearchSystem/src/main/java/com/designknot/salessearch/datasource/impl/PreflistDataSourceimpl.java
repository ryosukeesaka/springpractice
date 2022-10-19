package com.designknot.salessearch.datasource.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.designknot.salessearch.datasource.PreflistDataSource;
import com.designknot.salessearch.entity.ArealistMst;
import com.designknot.salessearch.entity.PreflistMst;
import com.designknot.salessearch.repository.ArealistRepository;
import com.designknot.salessearch.repository.PrefRepository;

@Component
public class PreflistDataSourceimpl implements PreflistDataSource{
	
	@Autowired
	private ArealistRepository repo;
	@Autowired
	private PrefRepository prefrepo;
	
	@Override
	public List<PreflistMst> findpref(String pref, String month) {
		List<PreflistMst> prefMsts = prefrepo.findpref(pref, month);
		return prefMsts;
	}

	@Override
	public List<ArealistMst> searchUriageDate() {
		 List<ArealistMst> date = repo.searchUriageDate();
		 return date;
	}

}
