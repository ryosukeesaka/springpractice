package com.designknot.salessearch.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.designknot.salessearch.datasource.ArealistDataSource;
import com.designknot.salessearch.entity.ArealistMst;
import com.designknot.salessearch.services.ArealistService;


@Service("ArealistService")
public class ArealistServiceImpl implements ArealistService {

	@Autowired
	private ArealistDataSource src;

	@Override
	public List<ArealistMst> findAll(String nen) {
		List<ArealistMst> itemMsts = src.findAll(nen);
		return itemMsts;
	}

	@Override
	public List<ArealistMst> searchUriageDate() {
		 List<ArealistMst> date = src.searchUriageDate();
		 return date;
	}


}
