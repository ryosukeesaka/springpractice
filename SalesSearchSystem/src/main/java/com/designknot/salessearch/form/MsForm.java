package com.designknot.salessearch.form;

import org.springframework.lang.Nullable;

import lombok.Data;

@Data

public class MsForm {
	
	private String uriage_date;
	
	private String pref_name;
	
	private String ms_cd;
	
	private String pref_cd;
	
	private String ms_name;
	
	@Nullable
	private String item_name;
	
	@Nullable
	private String category_name;
	
	private String area_name;
	
	private String area_cd;
	
}
