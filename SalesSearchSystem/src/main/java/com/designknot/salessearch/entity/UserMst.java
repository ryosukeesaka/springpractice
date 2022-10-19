package com.designknot.salessearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMst {

	private String user_id;

	private String user_passwd;

	private String user_name;

	private String security_cd;

	private String del_flg;

}
