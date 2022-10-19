package com.designknot.salessearch.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.designknot.salessearch.entity.PreflistMst;

@Mapper
public interface PrefRepository {
	
	@Select("select "
			+ "t2.pref_name as pref_name "
			+ ",t2.area_cd as area_cd "
			+ ",t1.area_name "
			+ ",t2.pref_cd "
    		+ ",sum(t4.price) as price "
    		+ "from "
    		+ "practice.area_mst t1 "
    		+ "left outer join "
    		+ "practice.pref_mst t2 "
    		+ "on "
    		+ "(t1.area_cd = t2.area_cd) "
    		+ "left outer join "
    		+ "practice.ms_mst t3 "
    		+ "on "
    		+ "(t2.pref_cd = t3.pref_cd) "
    		+ "left outer join "
    		+ "practice.uriage_daily t4 "
    		+ "on "
    		+ "(t3.ms_cd = t4.ms_cd) "
    		+ "where "
    		+ "substring(t4.uriage_date,1,6) = #{uriage_date} "
    		+ "and t2.area_cd = #{area_cd} "
    		+ "group by "
    		+ "t2.pref_name"
    		+ ",t1.area_name"
    		+ ",t2.area_cd "
    		+ ",t2.pref_cd "
			)
	@Results(id = "Date", value = {
			@Result(column = "pref_name", property = "pref_name"),
			@Result(column = "pref_cd", property = "pref_cd"),
			@Result(column = "area_cd", property = "area_cd"),
			@Result(column = "area_name", property = "area_name"),
			@Result(column = "sum", property = "sum")
			})
	List<PreflistMst> findpref(String area_cd, String uriage_date);
	

}