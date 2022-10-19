package com.designknot.salessearch.datasource;

import java.util.List;

import com.designknot.salessearch.entity.ArealistMst;


public interface ArealistDataSource {
	
	List<ArealistMst> findAll(String nen);
	
	List<ArealistMst> searchUriageDate();

}
