package com.designknot.salessearch.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.designknot.salessearch.entity.UserMst;

@Mapper

public interface UserMstRepository {



	@Results(id = "UserMst", value = {
			@Result(column = "use_id", property = "user_id"),
			@Result(column = "user_name", property = "user_name"),
			@Result(column = "user_password", property = "user_password"),
			@Result(column = "security_cd", property = "security_cd"),
			@Result(column = "del_flg", property = "del_flg")})

	@Select("<script>"
			+ "SELECT"
    		+ " user_name "
    		+ ",user_passwd "
    		+ ",user_id "
    		+ ",security_cd "
    		+ ",del_flg "
    		+ "FROM"
    		+ " practice.user_mst "
			+ "WHERE "
    		+ " del_flg = '0' "
			+ " <if test=\"state != null\">"
			+ "  And user_name = #{user_name}"
			+ " </if>"
			+ "</script>")
	List<UserMst> findAll();


	@Select("SELECT"
    		+ " user_name "
    		+ ",user_passwd "
    		+ ",user_id "
    		+ ",security_cd "
    		+ ",del_flg "
    		+ "FROM"
    		+ " practice.user_mst "
			+ "WHERE "
    		+ " del_flg = '0' "
			+ " And user_id = #{user_id}")
	@Results(id = "UserMstFindByUserid", value = {
			@Result(column = "user_id", property = "user_id"),
			@Result(column = "user_name", property = "user_name"),
			@Result(column = "user_passwd", property = "user_passwd"),
			@Result(column = "security_cd", property = "security_cd"),
			@Result(column = "del_flg", property = "del_flg")})
	UserMst findByUserid(String userid);
}
