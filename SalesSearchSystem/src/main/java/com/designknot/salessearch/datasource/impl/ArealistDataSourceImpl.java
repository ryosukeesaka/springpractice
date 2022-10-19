package com.designknot.salessearch.datasource.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.designknot.salessearch.datasource.ArealistDataSource;
import com.designknot.salessearch.entity.ArealistMst;
import com.designknot.salessearch.repository.ArealistRepository;

@Component
public class ArealistDataSourceImpl implements ArealistDataSource {

	@Autowired
	private ArealistRepository repo;

	@Override
	public List<ArealistMst> findAll(String nen) {
		List<ArealistMst> itemMsts = repo.findAll(nen);
		return itemMsts;
	}

	@Override
	public List<ArealistMst> searchUriageDate() {
		 List<ArealistMst> date = repo.searchUriageDate();
		 return date;
	}

}
