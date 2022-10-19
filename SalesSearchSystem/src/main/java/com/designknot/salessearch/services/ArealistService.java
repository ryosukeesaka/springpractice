package com.designknot.salessearch.services;

import java.util.List;

import com.designknot.salessearch.entity.ArealistMst;


public interface ArealistService {
	
	public List<ArealistMst> findAll(String nen);
	
	public List<ArealistMst> searchUriageDate();

}


